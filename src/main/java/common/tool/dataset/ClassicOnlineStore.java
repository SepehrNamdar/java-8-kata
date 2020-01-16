package common.tool.dataset;

import common.tool.entity.OnlineShoppingMall;

import javax.xml.bind.JAXB;
import java.io.File;

public class ClassicOnlineStore {
    protected final OnlineShoppingMall mall =
            JAXB.unmarshal(new File("./src/main/resources/data.xml"), OnlineShoppingMall.class);
}
