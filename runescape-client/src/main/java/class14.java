import java.applet.Applet;
import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public class class14 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -1821709893118478675L
   )
   public final long field287;
   @ObfuscatedName("i")
   public final XGrandExchangeOffer field288;
   @ObfuscatedName("j")
   String field289;
   @ObfuscatedName("dh")
   static IndexData field291;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -627899013
   )
   public final int field292;
   @ObfuscatedName("f")
   String field293;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "0"
   )
   static char method91(char var0) {
      return (char)(var0 == 198?'E':(var0 == 230?'e':(var0 == 223?'s':(var0 == 338?'E':(var0 == 339?'e':'\u0000')))));
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "1"
   )
   public String method92() {
      return this.field289;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "64"
   )
   public String method93() {
      return this.field293;
   }

   class14(Buffer var1, byte var2, int var3) {
      this.field289 = var1.readString();
      this.field293 = var1.readString();
      this.field292 = var1.readUnsignedShort();
      this.field287 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.field288 = new XGrandExchangeOffer();
      this.field288.method119(2);
      this.field288.method120(var2);
      this.field288.price = var4;
      this.field288.totalQuantity = var5;
      this.field288.quantitySold = 0;
      this.field288.spent = 0;
      this.field288.itemId = var3;
   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-1969223533"
   )
   static void method99(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < ItemComposition.field3500; ++var4) {
         ItemComposition var5 = ItemComposition.getItemDefinition(var4);
         if((!var1 || var5.field3546) && var5.notedTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               class8.field244 = -1;
               class11.field269 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class11.field269 = var2;
      class109.field1637 = 0;
      class8.field244 = var3;
      String[] var8 = new String[class8.field244];

      for(int var9 = 0; var9 < class8.field244; ++var9) {
         var8[var9] = ItemComposition.getItemDefinition(var2[var9]).name;
      }

      TextureProvider.method2413(var8, class11.field269);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;B)V",
      garbageValue = "-60"
   )
   public static void method100(Applet var0, String var1) {
      class56.field667 = var0;
      class56.field669 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-566711321"
   )
   static void method101(Component var0) {
      var0.removeKeyListener(class50.keyboard);
      var0.removeFocusListener(class50.keyboard);
      class50.field627 = -1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IZIZI)V",
      garbageValue = "-2051796246"
   )
   static void method102(int var0, boolean var1, int var2, boolean var3) {
      if(World.worldList != null) {
         class140.method2867(0, World.worldList.length - 1, var0, var1, var2, var3);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2018557731"
   )
   public static final void method103() {
      class134.field2007 = false;
      class134.field2009 = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)LEnum;",
      garbageValue = "-1732805095"
   )
   public static Enum method104(int var0) {
      Enum var1 = (Enum)Enum.field3412.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Enum.field3410.getConfigData(8, var0);
         var1 = new Enum();
         if(var2 != null) {
            var1.method4489(new Buffer(var2));
         }

         Enum.field3412.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IILclass163;LCollisionData;B)Z",
      garbageValue = "12"
   )
   public static final boolean method105(int var0, int var1, class163 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class162.field2311[var6][var7] = 99;
      class162.field2318[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class162.field2314[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class162.field2312[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var11 != var18) {
         var4 = class162.field2314[var11];
         var5 = class162.field2312[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod3055(1, var4, var5, var3)) {
            class162.field2310 = var4;
            class2.field17 = var5;
            return true;
         }

         int var15 = class162.field2318[var16][var17] + 1;
         if(var16 > 0 && class162.field2311[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
            class162.field2314[var18] = var4 - 1;
            class162.field2312[var18] = var5;
            var18 = var18 + 1 & 4095;
            class162.field2311[var16 - 1][var17] = 2;
            class162.field2318[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && class162.field2311[var16 + 1][var17] == 0 && (var12[var13 + 1][var14] & 19136896) == 0) {
            class162.field2314[var18] = var4 + 1;
            class162.field2312[var18] = var5;
            var18 = var18 + 1 & 4095;
            class162.field2311[var16 + 1][var17] = 8;
            class162.field2318[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class162.field2311[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class162.field2314[var18] = var4;
            class162.field2312[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class162.field2311[var16][var17 - 1] = 1;
            class162.field2318[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && class162.field2311[var16][var17 + 1] == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class162.field2314[var18] = var4;
            class162.field2312[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class162.field2311[var16][var17 + 1] = 4;
            class162.field2318[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class162.field2311[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class162.field2314[var18] = var4 - 1;
            class162.field2312[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class162.field2311[var16 - 1][var17 - 1] = 3;
            class162.field2318[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && class162.field2311[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class162.field2314[var18] = var4 + 1;
            class162.field2312[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class162.field2311[var16 + 1][var17 - 1] = 9;
            class162.field2318[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && class162.field2311[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class162.field2314[var18] = var4 - 1;
            class162.field2312[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class162.field2311[var16 - 1][var17 + 1] = 6;
            class162.field2318[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 127 && var17 < 127 && class162.field2311[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 1] & 19136992) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class162.field2314[var18] = var4 + 1;
            class162.field2312[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class162.field2311[var16 + 1][var17 + 1] = 12;
            class162.field2318[var16 + 1][var17 + 1] = var15;
         }
      }

      class162.field2310 = var4;
      class2.field17 = var5;
      return false;
   }
}
