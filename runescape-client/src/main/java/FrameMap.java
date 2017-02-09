import java.awt.Component;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 810453267
   )
   int field1467;
   @ObfuscatedName("r")
   int[][] field1468;
   @ObfuscatedName("o")
   int[] field1471;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1921210619
   )
   int field1473;

   FrameMap(int var1, byte[] var2) {
      this.field1467 = var1;
      Buffer var3 = new Buffer(var2);
      this.field1473 = var3.readUnsignedByte();
      this.field1471 = new int[this.field1473];
      this.field1468 = new int[this.field1473][];

      int var4;
      for(var4 = 0; var4 < this.field1473; ++var4) {
         this.field1471[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.field1473; ++var4) {
         this.field1468[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.field1473; ++var4) {
         for(int var5 = 0; var5 < this.field1468[var4].length; ++var5) {
            this.field1468[var4][var5] = var3.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "3"
   )
   static int method1703(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var0));
      return var1 == null?0:var1.method906();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "20"
   )
   public static void method1704(Component var0) {
      var0.addMouseListener(class115.mouse);
      var0.addMouseMotionListener(class115.mouse);
      var0.addFocusListener(class115.mouse);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)[LModIcon;",
      garbageValue = "2020047359"
   )
   public static ModIcon[] method1705(class182 var0, String var1, String var2) {
      int var3 = var0.method3284(var1);
      int var4 = var0.method3285(var3, var2);
      ModIcon[] var5;
      if(!class63.method1175(var0, var3, var4)) {
         var5 = null;
      } else {
         ModIcon[] var7 = new ModIcon[class225.field3216];

         for(int var8 = 0; var8 < class225.field3216; ++var8) {
            ModIcon var9 = var7[var8] = new ModIcon();
            var9.width = class225.field3212;
            var9.originalHeight = class225.field3213;
            var9.offsetX = class163.field2287[var8];
            var9.offsetY = class225.field3214[var8];
            var9.originalWidth = class47.field932[var8];
            var9.height = class225.field3211[var8];
            var9.palette = class225.field3215;
            var9.pixels = class225.field3218[var8];
         }

         class221.method4056();
         var5 = var7;
      }

      return var5;
   }
}
