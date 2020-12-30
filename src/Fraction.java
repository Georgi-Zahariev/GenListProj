
public class Fraction {
	//���� "���������� ����"
	
	// ��������: �������� � ����������
	 private long num,den;
	 
	//������ ������
	 
	 //��� �� ��������� � �����������
	 private long gcd(){
	//���������� n � d - ����������� ��������� �� ��������� � �����������
	//(������� �� ������� ����������, ������� � ����� �� ���) 
	   long n=num>=0?num:-num,
	        d=den>0?den:-den,       
	        t;
	//������������ �������� 0 ���������, �� ���� ���� �� ������� � ���� 0.
	//(�� ������� ���� �� � ��������� ����� �����������, �� ���� ������ �����������,
	// ������������ �� �� ��-�����������.)
	   if (n==0||d==0) return 0;
	//�������� � n �� ��-������� �� �����.
	   if (n<d){
		 t=n;
		 n=d;
		 d=t;
	   }
	//��������� �� ������ � �������
	   do{
		   t=n%d;
		   if (t==0) return d;
		   n=d;
		   d=t;
	   }while(true);
	 }
	 //"�������������" �� ����
	 private void normalize(){
		 //�������� �� ���������� 0
		 if (den==0) return;
		 //�������� �� �������� 0
		 if (num==0){
			 den=1;
			 return;
		 }
		 //������ �� �� ����� �� ���������
		 if (den<0){
			 den=-den;
			 num=-num;
		 }
		 //����������� �� ������
		 long d=gcd();
		 num/=d;
		 den/=d;
	 }
	 
	 //�������� ������
	 
	 //"������" ����������� (��� ���������): �� ������� ���� ��� �������� 0 
	 public Fraction(){
		 num=0;
		 den=1;
	 }
	 //����������� � ���� ��������� - �������� ���� � "���������� ����"
	 public Fraction (long n){
		 num=n;
		 den=1;
	 }
	 //����������� � ��� ���������� - �������� � ����������
	public Fraction (long n,long d){
	 //��������� �� �������� ��������� � ����������
		 num=n;
		 den=d;
	 //"�������������" �� ������
		 normalize();
	 }
	//"������": ���������� �� ������� ���������� �� ���� ����������
	 public long getNum(){
		 return num;
	 }
	 public long getDen(){
		 return den;
	 }
	 //"������": ���������� �� ������� ���������� �� ������� ����������
	 //�������� �� ������������� �� ���������!
	 public void setNum(long n){
		 num=n;
		 normalize();
	 }
	 public void setDen(long d){
		 den=d;
		 normalize();
	 }
	 //��������� �� ��� �� ������������ �� ����� �� ����� ����
	 public String toString(){
		 if (den==0)  return "NaN";
		 if (den==1) return Long.toString(num);
		 return num+"/"+den;
	 }
	 //�������� � ������ �� ����� ����
	 //�������� �� �����
	 public Fraction add(Fraction f){
		 return new Fraction(this.num*f.den+this.den*f.num,this.den*f.den);
	 }
	 //��������� �� �����
	 public Fraction sub(Fraction f){
		 return new Fraction(this.num*f.den-this.den*f.num,this.den*f.den);
	 }
	 //��������� �� �����
	 public Fraction mul(Fraction f){
		 return new Fraction(this.num*f.num,this.den*f.den);
	 }
	 //������� �� ����� (�������� ��� ������� �� ����!)
	 public Fraction div(Fraction f){
		 if (f.num==0) return new Fraction(1,0);//����� NaN
		 return new Fraction(this.num*f.den,this.den*f.num);
	 }
	 //�������� �� ���������� �� ������ ����
	 public Fraction reciprocal(){
		 //0 � NaN ����� ����������
		 if (num==0 || den==0) return new Fraction(1,0); //����� NaN
		 return new Fraction(den,num);
	 }
	 //��������� �� ������ �� ����
	 public Fraction power(int p){
	//���� ������ ������ �� 0 � NaN
		 if (p==0 && (num==0 || den==0)) return new Fraction(1,0);
		 //�������� ���������� t, ����� �� ������� �����
		 //"�������" r, ����� �� 1 (�� ������� ������������)
		 Fraction t=this,r=new Fraction(1);
		 //��� p � �����������, ������� t � �������� ����������
		 // � ������ p �����������
		 if (p<0) {
			 p=-p;
			 t=t.reciprocal();
		 }
		 //����� �� ���������� �� �������������� � r
		 for (int i=0;i<p;i++) r=r.mul(t);
		 return r;
	 }
	
}
