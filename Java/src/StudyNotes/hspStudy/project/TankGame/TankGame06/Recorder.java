package StudyNotes.hspStudy.project.TankGame.TankGame06;

import java.io.*;
import java.util.Vector;

/**
 * @version 1.0
 * @coding: utf-8
 * 该类用于记录信息.和文件交互
 */
public class Recorder {
    private static int ShotNumber = 0;
    //定义IO对象
    private static String recordFile = "F:\\Java_Learn\\Java\\src\\学习笔记\\hspStudy\\project\\TankGame\\TankGame06\\myRecord.txt";
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static Vector<EnemyTank> enemyTanks = null;
    private static Vector<Node> getNodesAndEnemyTankNum = null;
    private static Vector<Node> nodes = new Vector<>();
    public static Vector<EnemyTank> getEnemyTanks() {
        return enemyTanks;
    }

    public static String getRecordFile() {
        return recordFile;
    }

    public static void setRecordFile(String recordFile) {
        Recorder.recordFile = recordFile;
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    public static int getShotNumber() {
        return ShotNumber;
    }

    public static void setShotNumber(int shotNumber) {
        ShotNumber = shotNumber;
    }

    //当我方坦克击毁一辆敌方坦克就应该ShotNumber++
    public static void addShotNumber() {
        Recorder.ShotNumber++;
    }

    //增加方法保存成绩
    public static void keepRecord() throws IOException {
        bw = new BufferedWriter(new FileWriter(recordFile));
        bw.write(ShotNumber + "");
        bw.newLine();
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.isLive) {
                //保存enemyTank信息
                String record = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirect();
                bw.write(record);
                bw.newLine();
            }
        }
        bw.close();
    }

    public static Vector<Node> getNodesAndEnemyTankNum() {
        try {
            br = new BufferedReader(new FileReader(recordFile));
            ShotNumber = Integer.parseInt(br.readLine());
            //循环读取
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] xyd = line.split(" ");
                Node node = new Node(Integer.parseInt(xyd[0]),Integer.parseInt(xyd[1]),Integer.parseInt(xyd[2]));
                nodes.add(node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return nodes;
    }
}