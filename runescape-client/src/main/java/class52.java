import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public class class52 extends CacheableNode {
   @ObfuscatedName("f")
   public int[] field1102;
   @ObfuscatedName("z")
   static NodeCache field1103 = new NodeCache(64);
   @ObfuscatedName("y")
   public char field1104;
   @ObfuscatedName("p")
   public String field1105 = "null";
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1529665243
   )
   public int field1106;
   @ObfuscatedName("t")
   public char field1107;
   @ObfuscatedName("k")
   public int[] field1109;
   @ObfuscatedName("h")
   public String[] field1110;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1113076545
   )
   static int field1112;
   @ObfuscatedName("e")
   static int[] field1113;
   @ObfuscatedName("c")
   static int[] field1114;
   @ObfuscatedName("b")
   static String[] field1116;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1109490969
   )
   public int field1117 = 0;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "180450596"
   )
   void method1034(Buffer var1) {
      while(true) {
         int var2 = var1.method2481();
         if(var2 == 0) {
            return;
         }

         this.method1040(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-2083478491"
   )
   void method1040(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1107 = (char)var1.method2481();
      } else if(var2 == 2) {
         this.field1104 = (char)var1.method2481();
      } else if(var2 == 3) {
         this.field1105 = var1.method2503();
      } else if(var2 == 4) {
         this.field1106 = var1.method2526();
      } else {
         int var3;
         if(var2 == 5) {
            this.field1117 = var1.method2668();
            this.field1102 = new int[this.field1117];
            this.field1110 = new String[this.field1117];

            for(var3 = 0; var3 < this.field1117; ++var3) {
               this.field1102[var3] = var1.method2526();
               this.field1110[var3] = var1.method2503();
            }
         } else if(var2 == 6) {
            this.field1117 = var1.method2668();
            this.field1102 = new int[this.field1117];
            this.field1109 = new int[this.field1117];

            for(var3 = 0; var3 < this.field1117; ++var3) {
               this.field1102[var3] = var1.method2526();
               this.field1109[var3] = var1.method2526();
            }
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "-40637034"
   )
   static boolean method1043(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-235893822"
   )
   public static void method1044(int var0) {
      class186.field3002 = 1;
      XItemContainer.field200 = null;
      class186.field3003 = -1;
      class186.field3004 = -1;
      class186.field3005 = 0;
      class186.field3006 = false;
      class153.field2283 = var0;
   }
}
