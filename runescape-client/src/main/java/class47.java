import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class47 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1099089901
   )
   public static int field584;
   @ObfuscatedName("f")
   @Export("tt")
   static int[] tt;
   @ObfuscatedName("ei")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   static class269 field581;
   @ObfuscatedName("ea")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   static Font field580;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1950270879
   )
   public int field578;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   public Coordinates field582;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   public Coordinates field579;

   @ObfuscatedSignature(
      signature = "(ILhq;Lhq;)V"
   )
   public class47(int var1, Coordinates var2, Coordinates var3) {
      this.field578 = var1;
      this.field582 = var2;
      this.field579 = var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([Lgn;II)Lgn;",
      garbageValue = "-1932436509"
   )
   @Export("forOrdinal")
   public static RSEnum forOrdinal(RSEnum[] var0, int var1) {
      RSEnum[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         RSEnum var4 = var2[var3];
         if(var1 == var4.rsOrdinal()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("m")
   public static String method771(long var0) {
      class189.field2535.setTime(new Date(var0));
      int var2 = class189.field2535.get(7);
      int var3 = class189.field2535.get(5);
      int var4 = class189.field2535.get(2);
      int var5 = class189.field2535.get(1);
      int var6 = class189.field2535.get(11);
      int var7 = class189.field2535.get(12);
      int var8 = class189.field2535.get(13);
      return class189.field2534[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class189.field2536[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1370313005"
   )
   static void method770(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field1213[var5] != var0) {
            var2[var4] = World.field1213[var5];
            var3[var4] = World.field1219[var5];
            ++var4;
         }
      }

      World.field1213 = var2;
      World.field1219 = var3;
      class66.method1153(Coordinates.worldList, 0, Coordinates.worldList.length - 1, World.field1213, World.field1219);
   }
}
