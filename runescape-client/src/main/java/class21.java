import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public class class21 implements class115 {
   @ObfuscatedName("d")
   static final class21 field578 = new class21(1);
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 374893057
   )
   final int field579;
   @ObfuscatedName("v")
   static final class21 field580 = new class21(2);
   @ObfuscatedName("r")
   static final class21 field581 = new class21(3);
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -1812105187
   )
   static int field583;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -86594129
   )
   static int field584;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 108829877
   )
   public static int field585;
   @ObfuscatedName("a")
   static final class21 field587 = new class21(0);

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class21(int var1) {
      this.field579 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1565114944"
   )
   public int vmethod3214() {
      return this.field579;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass170;III)[LModIcon;",
      garbageValue = "230540117"
   )
   static ModIcon[] method571(class170 var0, int var1, int var2) {
      return !class126.method2817(var0, var1, var2)?null:FaceNormal.method1939();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZIZB)I",
      garbageValue = "34"
   )
   static int method572(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = Projectile.method105(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = Projectile.method105(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }
}
