package org.fundacionjala.diplomadoqa.guiautomation.page;

import static org.fundacionjala.diplomadoqa.guiautomation.ReTry.run;

/**
 * User: Ubaldo Villaseca
 * Date: 1/30/2019
 */
public abstract class Element {
    protected Element parent;

    public Element(Element element) {
        this.parent = element;
    }

    public void open() {
        run(() -> {
            if (this.parent != null) {
                parent.doOpen();
            }
        });
        doOpen();
    }

    protected abstract void doOpen();
}
