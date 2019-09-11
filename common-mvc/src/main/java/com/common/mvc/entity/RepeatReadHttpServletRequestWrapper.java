package com.common.mvc.entity;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RepeatReadHttpServletRequestWrapper extends HttpServletRequestWrapper {
    private final byte[] body;

    public RepeatReadHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        ServletInputStream inputStream = null;
        try {
            inputStream = request.getInputStream();
            List<Byte> byteList = new ArrayList<>();
            int data;
            while ((data = inputStream.read()) > -1) {
                byteList.add((byte) data);
            }
            body = new byte[byteList.size()];
            for (int i = 0; i < byteList.size(); i++) {
                body[i] = byteList.get(i);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(body);
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return inputStream.read();
            }
        };
    }
}
