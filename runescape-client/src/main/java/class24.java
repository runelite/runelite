import java.util.LinkedHashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
public class class24 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   public static final class24 field335;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   public static final class24 field329;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   public static final class24 field330;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = -1551980155
   )
   @Export("menuHeight")
   static int menuHeight;
   @ObfuscatedName("g")
   final String field331;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1666221925
   )
   final int field332;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -665921225
   )
   final int field334;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 767248977
   )
   final int field336;

   static {
      field335 = new class24("SMALL", 0, 0, 4);
      field329 = new class24("MEDIUM", 1, 1, 2);
      field330 = new class24("LARGE", 2, 2, 0);
   }

   class24(String var1, int var2, int var3, int var4) {
      this.field331 = var1;
      this.field332 = var2;
      this.field334 = var3;
      this.field336 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(FI)Z",
      garbageValue = "220314691"
   )
   boolean method171(float var1) {
      return var1 >= (float)this.field336;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1381483975"
   )
   public static final void method175() {
      while(true) {
         class9 var0 = (class9)class7.field220.method3605();
         if(var0 == null) {
            return;
         }

         var0.vmethod55();
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BIIS)Ljava/lang/String;",
      garbageValue = "-16984"
   )
   @Export("getString")
   public static String getString(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class273.field3712[var6 - 128];
               if(var7 == 0) {
                  var7 = '?';
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lcg;I)V",
      garbageValue = "315582119"
   )
   static void method176(World var0) {
      if(var0.method1516() != Client.isMembers) {
         Client.isMembers = var0.method1516();
         boolean var1 = var0.method1516();
         if(var1 != ItemComposition.isMembersWorld) {
            ItemComposition.items.reset();
            ItemComposition.itemModelCache.reset();
            ItemComposition.itemSpriteCache.reset();
            ItemComposition.isMembersWorld = var1;
         }
      }

      Varcs.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      Ignore.field790 = Client.socketType == 0?43594:var0.id + 40000;
      class12.field257 = Client.socketType == 0?443:var0.id + 50000;
      class70.myWorldPort = Ignore.field790;
   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "4"
   )
   static final void method172(boolean var0) {
      if(var0) {
         Client.field898 = class91.field1355?class150.field2105:class150.field2104;
      } else {
         LinkedHashMap var1 = class70.preferences.preferences;
         String var3 = class91.username;
         int var4 = var3.length();
         int var5 = 0;

         for(int var6 = 0; var6 < var4; ++var6) {
            var5 = (var5 << 5) - var5 + var3.charAt(var6);
         }

         Client.field898 = var1.containsKey(Integer.valueOf(var5))?class150.field2109:class150.field2103;
      }

   }
}
