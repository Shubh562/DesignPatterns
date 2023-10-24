public class IntelligentChildren extends Children implements Prototype {
    private int IQ;

    public int getIQ() {
        return IQ;
    }

    public void setIQ(int IQ) {
        this.IQ = IQ;
    }
    IntelligentChildren (){}
    IntelligentChildren(IntelligentChildren intelligentChildren ){
        super(intelligentChildren);
        this.IQ=intelligentChildren.IQ;
    }

    @Override
    public IntelligentChildren clone() {
        return new IntelligentChildren(this);
    }
}
