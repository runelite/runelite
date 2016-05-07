import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("World")
public class class25 {
   @ObfuscatedName("go")
   static class173 field626;
   @ObfuscatedName("b")
   static int[] field627 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 461641839
   )
   static int field628 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1379399327
   )
   static int field629 = 0;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = -1781143875
   )
   static int field630;
   @ObfuscatedName("k")
   static int[] field631 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1608703037
   )
   @Export("id")
   int field632;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -208410285
   )
   @Export("mask")
   int field633;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 983285275
   )
   @Export("playerCount")
   int field634;
   @ObfuscatedName("r")
   @Export("address")
   String field635;
   @ObfuscatedName("d")
   @Export("worldList")
   static class25[] field636;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -306769651
   )
   @Export("location")
   int field637;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -463347633
   )
   @Export("index")
   int field638;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 194074901
   )
   static int field640;
   @ObfuscatedName("m")
   @Export("activity")
   String field641;
   @ObfuscatedName("gr")
   static class173 field642;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "19136830"
   )
   boolean method580() {
      return (1 & this.field633) != 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1166502066"
   )
   boolean method581() {
      return (2 & this.field633) != 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-2"
   )
   boolean method582() {
      return (4 & this.field633) != 0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1112892779"
   )
   boolean method583() {
      return (8 & this.field633) != 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "69021914"
   )
   boolean method584() {
      return (536870912 & this.field633) != 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1728387776"
   )
   boolean method585() {
      return (33554432 & this.field633) != 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)Lclass227;",
      garbageValue = "815089600"
   )
   public static class227 method614(String var0, String var1, boolean var2) {
      File var3 = new File(class4.field72, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            class227 var10 = new class227(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(33 == class149.field2245) {
         var4 = "_rc";
      } else if(34 == class149.field2245) {
         var4 = "_wip";
      }

      File var5 = new File(class18.field258, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      class227 var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new class227(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new class227(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }
}
