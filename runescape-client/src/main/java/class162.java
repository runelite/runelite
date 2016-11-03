import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public class class162 implements class115 {
   @ObfuscatedName("q")
   public static final class162 field2641 = new class162(3, 1);
   @ObfuscatedName("f")
   public static final class162 field2642 = new class162(2, 2);
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -284096981
   )
   final int field2643;
   @ObfuscatedName("c")
   public static final class162 field2644 = new class162(1, 3);
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -812560761
   )
   public final int field2645;
   @ObfuscatedName("k")
   public static final class162 field2646 = new class162(0, 0);
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = 323690589
   )
   static int field2649;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIB)LWidget;",
      garbageValue = "-119"
   )
   public static Widget method3195(int var0, int var1) {
      Widget var2 = class144.method3012(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILclass170;IIIZI)V",
      garbageValue = "-23519887"
   )
   public static void method3196(int var0, class170 var1, int var2, int var3, int var4, boolean var5) {
      class186.field3007 = 1;
      class133.field2114 = var1;
      NPC.field794 = var2;
      class116.field2023 = var3;
      class28.field666 = var4;
      class93.field1626 = var5;
      class165.field2689 = var0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-116"
   )
   public int vmethod3197() {
      return this.field2643;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "1786395139"
   )
   static final void method3201(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class16 var9 = null;

      for(class16 var10 = (class16)Client.field413.method3864(); var10 != null; var10 = (class16)Client.field413.method3851()) {
         if(var0 == var10.field226 && var10.field228 == var1 && var2 == var10.field225 && var10.field231 == var3) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new class16();
         var9.field226 = var0;
         var9.field231 = var3;
         var9.field228 = var1;
         var9.field225 = var2;
         Projectile.method92(var9);
         Client.field413.method3844(var9);
      }

      var9.field230 = var4;
      var9.field232 = var5;
      var9.field224 = var6;
      var9.field233 = var7;
      var9.field234 = var8;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class162(int var1, int var2) {
      this.field2645 = var1;
      this.field2643 = var2;
   }
}
