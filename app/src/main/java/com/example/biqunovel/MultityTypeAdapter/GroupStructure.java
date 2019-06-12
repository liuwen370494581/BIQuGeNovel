package com.example.biqunovel.MultityTypeAdapter;

import java.io.Serializable;
import java.util.List;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2019/06/12 16:37
 * desc   :
 */
public class GroupStructure<P extends Object,C extends Object> implements Serializable {
    public P parent;
    public List<C> children;

    public boolean hasHeader() {
        if (parent != null) {
            return true;
        }
        return false;
    }

    public int getChildrenCount() {
        if (children != null) {
            return children.size();
        }
        return 0;
    }

    public boolean equalParent(Object parent){
        return this.parent==parent;
    }

    public int count() {
        return hasHeader() ? 1 + getChildrenCount() : getChildrenCount();
    }
}
