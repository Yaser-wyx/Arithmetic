package HDU;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public class Node
    {
        private int[][] info;
        private int cost;
        private String road;

        public Node(int[][] info,int cost,String road)
        {
            this.cost = cost;
            this.info = info;
            this.road = road;
        }
    }

    //    public class Compa implements Comparator<Node>
//    {
//
//        @Override
//        public int compare(Node n0, Node n1) {
//            // TODO Auto-generated method stub
//            //升序
//            if(n0.cost<n1.cost)
//            {
//                return -1;
//            }
//            return 0;
//        }
//
//    }
    public void run()
    {
//        Compa com = new Compa();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext())
        {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();

            int[][] data = new int[2][4];
            for(int i=0;i<4;i++)
            {
                data[0][i] = s1.charAt(i)-48;
            }
            for(int i=3;i>=0;i--)
            {
                data[1][3-i] = s1.charAt(i+4)-48;
            }


            int target[][] = new int[2][4];
            for(int i=0;i<4;i++)
            {
                target[0][i] = s2.charAt(i)-48;
            }
            for(int i=3;i>=0;i--)
            {
                target[1][3-i] = s2.charAt(i+4)-48;
            }

            List<Node> list = new ArrayList<Node>();

            int[][] da = new int[2][4];
            init(da,data);
            int cos = cost(data,target);
            Node node = new Node(da,cos,"");
            list.add(node);
            int level = 1;
            while(list.size()>0)
            {
//                Collections.sort(list,com);
                Node no = list.get(0);
                int p = 0;
                for(int i=1;i<list.size();i++)
                {
                    Node nod = list.get(i);
                    if(nod.cost<no.cost)
                    {
                        no = nod;
                        p = i;
                    }
                }

                list.remove(p);
                String str = no.road;
                int[][] temp = no.info;

                int[][] temp1 = new int[2][4];
                if(str.length()==0||str.length()>0&&str.charAt(str.length()-1)!='A')
                {
                    init(temp1,temp);
                    A(temp1);
                    int a = cost(temp1,target);
                    if(a==0)
                    {
                        System.out.println(str+"A");
                        break;
                    }else
                    {
                        Node n = new Node(temp1,a+level,str+"A");
                        list.add(n);
                    }

                }

                int[][] temp2 = new int[2][4];
                init(temp2,temp);
                B(temp2);
                int b = cost(temp2,target);
                if(b==0)
                {
                    System.out.println(str+"B");
                    break;
                }else
                {
                    Node n = new Node(temp2,b+level,str+"B");
                    list.add(n);
                }

                int[][] temp3 = new int[2][4];
                init(temp3,temp);
                C(temp3);
                int c = cost(temp3,target);
                if(c==0)
                {
                    System.out.println(str+"C");
                    break;
                }else
                {
                    Node n = new Node(temp3,c+level,str+"C");
                    list.add(n);
                }


                level++;

            }



        }

    }
    public void init(int[][] d,int[][] t)
    {
        for(int i=0;i<2;i++)
        {
            for (int j=0;j<4;j++)
            {
                d[i][j] = t[i][j];
            }
        }
    }
    public void A(int[][] d)
    {
        int[] tmp = {d[0][0],d[0][1],d[0][2],d[0][3]};
        for(int i=0;i<4;i++)
        {
            d[0][i] = d[1][i];
            d[1][i] = tmp[i];
        }
    }
    public void C(int[][] d)
    {
        int tmp = d[0][1];
        d[0][1] = d[1][1];
        d[1][1] = d[1][2];
        d[1][2] = d[0][2];
        d[0][2] = tmp;
    }

    public void B(int[][] d)
    {
        int tmp = d[0][3];
        for(int i=3;i>0;i--)
        {
            d[0][i] = d[0][i-1];
        }
        d[0][0] = tmp;
        tmp = d[1][3];
        for(int i=3;i>0;i--)
        {
            d[1][i] = d[1][i-1];
        }
        d[1][0] = tmp;
    }
    public int cost(int[][] t,int[][] d)
    {
        int number = 0;
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<4;j++)
            {
                if(t[i][j]!=d[i][j])
                {
                    number++;
                }
            }
        }

        return number;
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        new Main().run();
    }

}