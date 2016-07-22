import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public final class class24 extends class211 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 633581289
   )
   int field601;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -741387321
   )
   int field602;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1484579393
   )
   int field605;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 204319601
   )
   int field606;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -513461871
   )
   int field607;
   @ObfuscatedName("ey")
   static class81[] field608;
   @ObfuscatedName("k")
   class67 field609;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -449175921
   )
   int field610;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1421919267
   )
   int field611;
   @ObfuscatedName("u")
   int[] field612;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 455298817
   )
   int field613;
   @ObfuscatedName("p")
   class67 field614;
   @ObfuscatedName("r")
   class42 field615;
   @ObfuscatedName("pk")
   @ObfuscatedGetter(
      intValue = 1783873893
   )
   static int field616;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 581944595
   )
   int field617;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = -1992377105
   )
   static int field620;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2028383293
   )
   int field621;
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = -1827202681
   )
   @Export("cameraZ")
   static int field622;
   @ObfuscatedName("m")
   static class202 field624 = new class202();

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1937552461"
   )
   void method582() {
      int var1 = this.field621;
      class42 var2 = this.field615.method851();
      if(var2 != null) {
         this.field621 = var2.field986;
         this.field601 = var2.field987 * 128;
         this.field610 = var2.field965;
         this.field611 = var2.field989;
         this.field612 = var2.field990;
      } else {
         this.field621 = -1;
         this.field601 = 0;
         this.field610 = 0;
         this.field611 = 0;
         this.field612 = null;
      }

      if(this.field621 != var1 && null != this.field609) {
         class18.field254.method1228(this.field609);
         this.field609 = null;
      }

   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-636705073"
   )
   static final void method592(int var0, int var1) {
      int var2 = class1.field25.method4094("Choose Option");

      int var3;
      for(var3 = 0; var3 < client.field412; ++var3) {
         class227 var4 = class1.field25;
         String var7;
         if(client.field328[var3].length() > 0) {
            var7 = client.field417[var3] + " " + client.field328[var3];
         } else {
            var7 = client.field417[var3];
         }

         int var6 = var4.method4094(var7);
         if(var6 > var2) {
            var2 = var6;
         }
      }

      var2 += 8;
      var3 = client.field412 * 15 + 22;
      int var8 = var0 - var2 / 2;
      if(var2 + var8 > class12.field174) {
         var8 = class12.field174 - var2;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      int var5 = var1;
      if(var3 + var1 > class19.field264) {
         var5 = class19.field264 - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      client.field517 = true;
      class163.field2699 = var8;
      class130.field2099 = var5;
      class23.field600 = var2;
      class34.field788 = client.field412 * 15 + 22;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-1624256181"
   )
   public static boolean method593(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}
