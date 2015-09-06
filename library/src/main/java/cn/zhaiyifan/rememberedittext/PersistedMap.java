package cn.zhaiyifan.rememberedittext;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 一个通过SharedPreference存放的持久化map，由于实际提供服务的数据来源
 * 是内存中的map，所以可以做到同步返回，不用依赖于SharedPreference实际操作完成。
 */
class PersistedMap {

    private static final String KEY_NOT_FOUND_VALUE = "";
    private final SharedPreferences preferences;
    private Map<String, String> map = new ConcurrentHashMap<>();

    public PersistedMap(Context context, String mapName) {
        preferences = context.getSharedPreferences(PersistedMap.class.getSimpleName() + mapName, Context.MODE_PRIVATE);
        Map<String, ?> allPreferences = preferences.getAll();

        for (String key : allPreferences.keySet()) {
            String value = preferences.getString(key, KEY_NOT_FOUND_VALUE);

            if (!value.equals(KEY_NOT_FOUND_VALUE)) {
                map.put(key, value);
            }
        }
    }

    public String get(String tag) {
        return map.get(tag);
    }

    public void put(String tag, String value) {
        map.put(tag, value);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString(tag, value);
        edit.apply();
    }

    public void remove(String tag) {
        map.remove(tag);
        SharedPreferences.Editor edit = preferences.edit();
        edit.remove(tag);
        edit.apply();
    }

    public void clear() {
        map.clear();
        SharedPreferences.Editor edit = preferences.edit();
        edit.clear();
        edit.apply();
    }
}
