package com.kenhome.common.utils.code;

import tk.mybatis.mapper.genid.GenId;

/**
 * 实体ID生成器
 * @author cmk
 * @version 1.0
 * @create 2018-09-17 11:02:06
 */
public class EntityIdGenerator implements GenId<String> {

    private static final int ID_LENGTH = 12;
    private static final int ID_RADIX = 36;

    public static String generateId() {
        String id = CodeGenerator.generate(ID_LENGTH, ID_RADIX);
        return id;
    }

    @Override
    public String genId(String table, String column) {
        return generateId();
    }

}
