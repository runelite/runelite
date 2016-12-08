import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class47 {
   @ObfuscatedName("o")
   @Export("chatLineMap")
   static final Map chatLineMap = new HashMap();
   @ObfuscatedName("b")
   static final class136 field939 = new class136();
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1245039155
   )
   static int field940 = 0;
   @ObfuscatedName("e")
   static int[] field943;
   @ObfuscatedName("m")
   static final class121 field945 = new class121(1024);

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "114"
   )
   static void method861(String var0, String var1, String var2) {
      class41.loginMessage1 = var0;
      class41.loginMessage2 = var1;
      class41.loginMessage3 = var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LGameEngine;I)V",
      garbageValue = "1210826834"
   )
   static void method864(GameEngine var0) {
      if(class115.field1820 == 1 || !class148.field2047 && class115.field1820 == 4) {
         int var1 = class41.field860 + 280;
         if(class115.field1823 >= var1 && class115.field1823 <= var1 + 14 && class115.field1825 >= 4 && class115.field1825 <= 18) {
            class22.method205(0, 0);
            return;
         }

         if(class115.field1823 >= 15 + var1 && class115.field1823 <= 80 + var1 && class115.field1825 >= 4 && class115.field1825 <= 18) {
            class22.method205(0, 1);
            return;
         }

         int var2 = class41.field860 + 390;
         if(class115.field1823 >= var2 && class115.field1823 <= 14 + var2 && class115.field1825 >= 4 && class115.field1825 <= 18) {
            class22.method205(1, 0);
            return;
         }

         if(class115.field1823 >= 15 + var2 && class115.field1823 <= 80 + var2 && class115.field1825 >= 4 && class115.field1825 <= 18) {
            class22.method205(1, 1);
            return;
         }

         int var3 = 500 + class41.field860;
         if(class115.field1823 >= var3 && class115.field1823 <= 14 + var3 && class115.field1825 >= 4 && class115.field1825 <= 18) {
            class22.method205(2, 0);
            return;
         }

         if(class115.field1823 >= var3 + 15 && class115.field1823 <= var3 + 80 && class115.field1825 >= 4 && class115.field1825 <= 18) {
            class22.method205(2, 1);
            return;
         }

         int var4 = 610 + class41.field860;
         if(class115.field1823 >= var4 && class115.field1823 <= 14 + var4 && class115.field1825 >= 4 && class115.field1825 <= 18) {
            class22.method205(3, 0);
            return;
         }

         if(class115.field1823 >= var4 + 15 && class115.field1823 <= 80 + var4 && class115.field1825 >= 4 && class115.field1825 <= 18) {
            class22.method205(3, 1);
            return;
         }

         if(class115.field1823 >= 708 + class41.field860 && class115.field1825 >= 4 && class115.field1823 <= class41.field860 + 708 + 50 && class115.field1825 <= 20) {
            class41.worldSelectShown = false;
            class41.field830.method4092(class41.field860, 0);
            RSCanvas.field1766.method4092(382 + class41.field860, 0);
            class41.field840.method3995(382 + class41.field860 - class41.field840.originalWidth / 2, 18);
            return;
         }

         if(class41.field857 != -1) {
            World var5 = World.worldList[class41.field857];
            class104.selectWorld(var5);
            class41.worldSelectShown = false;
            class41.field830.method4092(class41.field860, 0);
            RSCanvas.field1766.method4092(class41.field860 + 382, 0);
            class41.field840.method3995(class41.field860 + 382 - class41.field840.originalWidth / 2, 18);
            return;
         }
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1487170829"
   )
   static int method871() {
      return Client.isResized?2:1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1538490606"
   )
   public static void method873() {
      class138.field1926.method2488();
      class138.field1929 = 1;
      class138.field1930 = null;
   }
}
