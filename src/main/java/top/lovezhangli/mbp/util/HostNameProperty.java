package top.lovezhangli.mbp.util;

import ch.qos.logback.core.PropertyDefinerBase;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Desc: HostNameProperty
 * Author: Xu He
 * created: 2021/5/7 13:24
 */

public class HostNameProperty extends PropertyDefinerBase {
    @Override
    public String getPropertyValue() {
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String hostName = addr == null ? null : addr.getHostName();
        return hostName;
    }
}
