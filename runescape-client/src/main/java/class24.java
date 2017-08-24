import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class24 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lg;"
   )
   public static final class24 field370;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lg;"
   )
   public static final class24 field369;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lg;"
   )
   public static final class24 field373;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1401072905
   )
   final int field374;
   @ObfuscatedName("r")
   final String field371;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -361316121
   )
   final int field372;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 794708615
   )
   final int field368;

   static {
      field370 = new class24("SMALL", 1, 0, 4);
      field369 = new class24("MEDIUM", 0, 1, 2);
      field373 = new class24("LARGE", 2, 2, 0);
   }

   class24(String var1, int var2, int var3, int var4) {
      this.field371 = var1;
      this.field372 = var2;
      this.field368 = var3;
      this.field374 = var4;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(FB)Z",
      garbageValue = "38"
   )
   boolean method198(float var1) {
      return var1 >= (float)this.field374;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lii;Lii;IZI)Leg;",
      garbageValue = "2065233574"
   )
   public static Frames method204(IndexDataBase var0, IndexDataBase var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.getChilds(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.getChild(var2, var5[var6]);
         if(var7 == null) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9;
            if(var3) {
               var9 = var1.getChild(0, var8);
            } else {
               var9 = var1.getChild(var8, 0);
            }

            if(var9 == null) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new Frames(var0, var1, var2, var3);
         } catch (Exception var11) {
            return null;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)[Lg;",
      garbageValue = "-2024910865"
   )
   static class24[] method203() {
      return new class24[]{field373, field370, field369};
   }

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIZI)V",
      garbageValue = "-1949275647"
   )
   static final void method202(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            Client.field1077[Client.menuOptionCount] = var6;
            ++Client.menuOptionCount;
         }

      }
   }

   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "-8"
   )
   @Export("isIgnored")
   static boolean isIgnored(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = Frames.method2925(var0, class8.field243);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(Frames.method2925(var3.name, class8.field243))) {
               return true;
            }

            if(var1.equalsIgnoreCase(Frames.method2925(var3.previousName, class8.field243))) {
               return true;
            }
         }

         return false;
      }
   }
}
