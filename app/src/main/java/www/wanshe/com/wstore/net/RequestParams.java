package www.wanshe.com.wstore.net;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 封装所有的请求参数到HashMap中
 */

public class RequestParams {
    //线程安全的hashmap
    public ConcurrentHashMap<String, String> urlParams = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, Object> urlFile = new ConcurrentHashMap<>();

    //创建空的RequestParams实例
    public RequestParams() {
        this((Map<String, String>) null);
    }

    //创建带参实例
    public RequestParams(Map<String, String> source) {
        if (source != null) {
            for (Map.Entry<String, String> entry : source.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }

    }

    //
    public RequestParams(final String key, final String value) {
        this(new HashMap<String, String>() {
            {
                put(key, value);
            }
        });

    }

    private void put(String key, String value) {
        if (key != null && value != null) {
            urlParams.put(key, value);
        }
    }

    public void put(String key, Object object) throws FileNotFoundException {
        if (key != null) {
            urlFile.put(key, object);
        }
    }

    public boolean hasParams() {
        if (urlParams.size() > 0 || urlFile.size() > 0) {
            return true;
        }
        return false;
    }
}
