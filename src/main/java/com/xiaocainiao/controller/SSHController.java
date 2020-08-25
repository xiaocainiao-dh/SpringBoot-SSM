package com.xiaocainiao.controller;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import com.xiaocainiao.util.DateUtil;
import com.xiaocainiao.util.MD5;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class SSHController {

    @PostMapping("/hservice.action")
    public String hservice1(HttpServletRequest request, HttpServletResponse response) {

        Session ssh = null;
        Connection conn = null;
        // 返回值
        String retu = "1";
        // 将Terminal屏幕上的文字
        StringBuffer resultMsg = new StringBuffer();

        StringBuffer resultMsgErr = new StringBuffer();

        StringBuffer tempMsg = new StringBuffer();

        // 文件的指定值（随机生成）
        String printVal = "abc123";

        // 脚本存放位置(可放于用于监控文件夹中，可设置多个文件夹每个文件夹用";"隔开)
        String remoteFile = null;

        // 远程服务器的用户名
        String userName = null;
        // 远程服务器密码
        String password = null;
        // 远程服务器地址
        String host = request.getParameter("host");
        // 远程服务器端口
        int port = Integer.parseInt(request.getParameter("port"));

        switch (host) {
            case "172.16.56.43":
                userName = "";
                password = "";
                remoteFile = "/app/bea/rw";
                break;
            case "172.16.56.44":
                userName = "";
                password = "";
                remoteFile = "/app/bea/rw";
                break;
            case "172.16.56.60":
                userName = "";
                password = "";
                remoteFile = "/weblogic/rw";
                break;
            case "172.16.56.61":
                userName = "";
                password = "";
                remoteFile = "/weblogic/rw";
                break;
            case "172.16.57.1":
                userName = "";
                password = "";
                remoteFile = "/app/bea/rw";
                break;
            case "172.16.57.2":
                userName = "";
                password = "";
                remoteFile = "/app/bea/rw";
                break;
            case "172.16.57.3":
                userName = "";
                password = "";
                remoteFile = "/app/bea/rw";
                break;
            case "172.16.57.4":
                userName = "";
                password = "";
                remoteFile = "/app/bea/rw";
                break;
            case "192.168.160.129":
                userName = "dh";
                password = "dh";
                remoteFile = "/home/dh;/home/dh;";
                break;
            default:
                userName = null;
                password = null;
                remoteFile = null;
                break;
        }

        if (userName == null || password == null || remoteFile == null) {
            retu = "参数异常";
        } else {
            String keys = request.getParameter("keys");
            String n = DateUtil.getFormatNowDay();
            MD5 m = new MD5();
            if (!m.getMD5ofStr(n + "xiaxuhai").equals(keys)) {
                retu = "非法访问";
            } else {
                try {
                    //指明连接主机的IP地址
                    conn = new Connection(host, port);
                    //连接到主机
                    conn.connect();
                    //使用用户名和密码校验
                    boolean isconn = conn.authenticateWithPassword(userName, password);
                    if (!isconn) {
                        // TODO log
                        System.err.println("用户名称或者是密码不正确");
                        retu = "用户名称或者是密码不正确";
                    } else {
                        //执行命令
                        ssh = conn.openSession();

                        // 获取所有要验证的文件夹，并进行命令的拼接
                        String[] paths = remoteFile.split(";");
                        StringBuffer cmd = new StringBuffer();
                        for (int i = 0; i < paths.length; i++) {
                            cmd.append("cd " + paths[i] + "; bash ./rw.sh " + printVal + ";");
                            tempMsg.append(printVal);
                        }
                        ssh.execCommand(cmd.toString());

                        //将Terminal屏幕上的文字全部打印出来
                        InputStream is = new StreamGobbler(ssh.getStdout());
                        BufferedReader brs = new BufferedReader(new InputStreamReader(is));
                        while (true) {
                            String line = brs.readLine();
                            if (line == null) {
                                break;
                            }
                            resultMsg.append(line);
                        }

                        // 控制台错误信息
                        InputStream iser = new StreamGobbler(ssh.getStderr());
                        BufferedReader brserr = new BufferedReader(new InputStreamReader(iser));
                        while (true) {
                            String line = brserr.readLine();
                            if (line == null) {
                                break;
                            }
                            resultMsgErr.append(line);
                        }
                    }
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    retu = e.getMessage();
                } finally {
                    //连接的Session和Connection对象都需要关闭
                    if (ssh != null) {
                        ssh.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                }
            }
        }

        response.setCharacterEncoding("UTF-8");
        PrintWriter pw;
        try {
            if ((!tempMsg.toString().equals(resultMsg.toString())) && "1".equals(retu)) {
                retu = "读写文件失败";
                // TODO log
                System.out.println("resultMsgErr：" + resultMsgErr);
            }
            String result = retu == "1" ? "读写文件成功" : retu;
            System.out.println("执行结果：" + result);
            pw = response.getWriter();
            pw.write(retu);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
