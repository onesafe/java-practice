package designpatten.structural.bridge.beforeBridge;

public interface Computer {

    void sale();
}

class Desktop implements Computer {
    @Override
    public void sale() {
        System.out.println("销售台式机!");
    }
}

class Laptop implements Computer {
    @Override
    public void sale() {
        System.out.println("销售笔记本!");
    }
}

class Pad implements Computer {
    @Override
    public void sale() {
        System.out.println("销售平板电脑!");
    }
}

// -------------

class LenovoDesktop extends Desktop {
    @Override
    public void sale() {
        System.out.println("销售联想台式机!");
    }
}

class LenovoLaptop extends Laptop {
    @Override
    public void sale() {
        System.out.println("销售联想笔记本");
    }
}

class LenovePad extends Pad {
    @Override
    public void sale() {
        System.out.println("销售联想平板！");
    }
}


// -------------

class ShenzhouDesktop extends Desktop {
    @Override
    public void sale() {
        System.out.println("销售神州台式机!");
    }
}

class ShenzhouLaptop extends Laptop {
    @Override
    public void sale() {
        System.out.println("销售神州笔记本");
    }
}

class ShenzhouPad extends Pad {
    @Override
    public void sale() {
        System.out.println("销售神州平板！");
    }
}


// -------------

class DellDesktop extends Desktop {
    @Override
    public void sale() {
        System.out.println("销售Dell台式机!");
    }
}

class DellLaptop extends Laptop {
    @Override
    public void sale() {
        System.out.println("销售Dell笔记本");
    }
}

class DellPad extends Pad {
    @Override
    public void sale() {
        System.out.println("销售Dell平板！");
    }
}