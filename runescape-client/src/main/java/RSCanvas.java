import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.mapping.Replace;

@ObfuscatedName("ds")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("f")
   Component field1775;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1365185117
   )
   public static int field1777;

   public final void paint(Graphics var1) {
      this.field1775.paint(var1);
   }

   public final void update(Graphics var1) {
      this.field1775.update(var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1965013775"
   )
   public static int method2123(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var2 + var0) / var1 - var2;
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(III)Ljava/lang/String;",
      garbageValue = "-28010194"
   )
   static final String method2130(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?XItemContainer.method153(16711680):(var2 < -6?XItemContainer.method153(16723968):(var2 < -3?XItemContainer.method153(16740352):(var2 < 0?XItemContainer.method153(16756736):(var2 > 9?XItemContainer.method153('\uff00'):(var2 > 6?XItemContainer.method153(4259584):(var2 > 3?XItemContainer.method153(8453888):(var2 > 0?XItemContainer.method153(12648192):XItemContainer.method153(16776960))))))));
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-49"
   )
   public static int method2131(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   RSCanvas(Component var1) {
      this.field1775 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)LKitDefinition;",
      garbageValue = "1"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.field2830.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.field2834.getConfigData(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.method3556(new Buffer(var2));
         }

         KitDefinition.field2830.put(var1, (long)var0);
         return var1;
      }
   }
}
