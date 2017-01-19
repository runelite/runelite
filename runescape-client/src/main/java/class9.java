import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public final class class9 {
   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2119295387"
   )
   static final void method95(int var0, int var1) {
      if(class109.method1999(var0)) {
         class107.method1985(Widget.widgets[var0], var1);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1642061727"
   )
   static void method96() {
      for(class31 var0 = (class31)class31.field703.method2330(); null != var0; var0 = (class31)class31.field703.method2346()) {
         if(null != var0.field711) {
            CombatInfoListHolder.field758.method869(var0.field711);
            var0.field711 = null;
         }

         if(var0.field716 != null) {
            CombatInfoListHolder.field758.method869(var0.field716);
            var0.field716 = null;
         }
      }

      class31.field703.method2324();
   }

   @ObfuscatedName("ev")
   @ObfuscatedSignature(
      signature = "(LWidget;B)LWidget;",
      garbageValue = "8"
   )
   static Widget method97(Widget var0) {
      int var1 = class30.method650(class170.method3147(var0));
      if(var1 == 0) {
         return null;
      } else {
         for(int var2 = 0; var2 < var1; ++var2) {
            var0 = class108.method1988(var0.parentId);
            if(null == var0) {
               return null;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-77"
   )
   static void method98(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class225.field3221 = var1.readUnsignedShort();
      class181.field2710 = new int[class225.field3221];
      class225.field3220 = new int[class225.field3221];
      class119.field1865 = new int[class225.field3221];
      class109.field1742 = new int[class225.field3221];
      class44.field888 = new byte[class225.field3221][];
      var1.offset = var0.length - 7 - class225.field3221 * 8;
      class225.field3218 = var1.readUnsignedShort();
      class225.field3219 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class225.field3221; ++var3) {
         class181.field2710[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3221; ++var3) {
         class225.field3220[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3221; ++var3) {
         class119.field1865[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3221; ++var3) {
         class109.field1742[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class225.field3221 * 8 - (var2 - 1) * 3;
      class225.field3217 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class225.field3217[var3] = var1.read24BitInt();
         if(class225.field3217[var3] == 0) {
            class225.field3217[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class225.field3221; ++var3) {
         int var4 = class119.field1865[var3];
         int var5 = class109.field1742[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class44.field888[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var10 * var4 + var9] = var1.readByte();
               }
            }
         }
      }

   }
}
