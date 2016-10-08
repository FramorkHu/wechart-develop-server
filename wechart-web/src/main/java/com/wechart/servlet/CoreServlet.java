package com.wechart.servlet;

import com.wechart.utils.SignUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by huyan on 2016/10/8.
 */
public class CoreServlet extends HttpServlet {


    /**
     * 处理微信服务器发来的消息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 微信加密签名
        String signature = req.getParameter("signature");
        // 时间戳
        String timestamp = req.getParameter("timestamp");
        // 随机数
        String nonce = req.getParameter("nonce");
        // 随机字符串
        String echostr = req.getParameter("echostr");

        PrintWriter out = resp.getWriter();
        // 请求校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            out.print(echostr);
        }
        out.close();
        out = null;
    }
}
