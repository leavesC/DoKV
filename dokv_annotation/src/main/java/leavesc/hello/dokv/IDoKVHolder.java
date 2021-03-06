package leavesc.hello.dokv;

/**
 * 作者：leavesC
 * 时间：2019/1/5 1:01
 * 描述：
 * GitHub：https://github.com/leavesC
 * Blog：https://www.jianshu.com/u/9df45b87cfdf
 */
public interface IDoKVHolder {

    //序列化
    String serialize(String key, Object src);

    //反序列化
    <T> T deserialize(String key, Class<T> classOfT);

    //移除指定对象
    void remove(String key);

    //删除全局的缓存数据
    void clear();

}