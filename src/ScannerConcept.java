import java.util.Scanner;

public class ScannerConcept {
    /**
     * Java Scanner用来获取用户的在控制台的输入
     * Java Scanner只能用在psvm入口函数中
     */

    public static void main(String[] args) {

        //创建Scanner对象
        Scanner scanner=new Scanner(System.in);

        /**
         * next()和has next()
         *
         * 测试输入：12 34 56
         *          ruby good
         * 1. 要读到有效字符后才算输入结束,有效字符出现之前的空格，next()方法会将其忽略
         * 2. 读到有效字符后将有效字符后面输入的空白作为分隔符
         * 3. while has next()换行符不会终止程序，只作为分隔符，需要手动设置break条件
         */
        if(scanner.hasNext()){
            String text=scanner.next();
            System.out.println("if has next 输出： "+text);
        }

        while(scanner.hasNext()){
            String text=scanner.next();
            System.out.println("while has next 输出： "+text);
        }

        for(int i=0;i<5;i++){
            if(scanner.hasNext()){
                String text=scanner.next();
                System.out.println("手动break循环 输出： "+text);
            }
        }


        /**
         * nextByte(),nextDouble(),nextFloat(),nextInt,nextLong,nextShort()都由next()转化而来，以空格和TAB结束
         *
         * hasNextInt()和nextInt()
         *
         * 1. while换行符不会终止，需要手动控制循环次数，或者输入非int类型字符会终止
         * 2. 读入的直接是int类型，无需类型转换
         */

        if(scanner.hasNextInt()){
            int text=scanner.nextInt();
            System.out.println("if has nextInt 输出： "+text);
        }

        while(scanner.hasNextInt()){
            int text=scanner.nextInt();
            System.out.println("while has nextInt 输出： "+text);
        }

        for(int i=0;i<5;i++){
            int text=scanner.nextInt();
            System.out.println("手动break循环 输出： "+text);
        }


        /**
         * nextLine()和has nextLine()
         *
         * 1. 返回输入回车之前的所有字符，包括空格
         * 2. 以回车为分隔符 while has nextLine() 或者结束符 if has nextLine()
         * 3. while has nextLine()换行符不会终止，需要手动设置break条件
         */
        if(scanner.hasNextLine()){
            String text=scanner.nextLine();
            System.out.println("if has nextLine 输出： "+text);
        }

        while(scanner.hasNextLine()){
            String text=scanner.nextLine();
            System.out.println("while has nextLine 输出： "+text);
        }

        for(int i=0;i<5;i++){
            String text=scanner.nextLine();
            System.out.println("手动break循环 输出： "+text);
        }

        //使用完关闭scanner
        scanner.close();
    }

    /**
     * 总结
     *
     * 1. nextByte(),nextDouble(),nextFloat(),nextInt,nextLong,nextShort()都由next()转化而来，以空格，TAB和换行符作为分隔符
     * 2. while循环中换行符只是分隔符，不能终止输入阻塞，需要手动设置break条件
     * 3. hasNext()不能读入空白，hasNextLine()以行读入可以读入空格，hasNextLine可以结合字符串分割String.split()使用
     * 4. scanner.useDelimiter(pattern)用在scanner创建之后可以按照指定的pattern分割输入,如果指定分隔符没有空格，回车等，则默认分隔符将不再起效
     */
}
