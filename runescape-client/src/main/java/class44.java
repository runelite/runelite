import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class44 extends WorldMapData {
   @ObfuscatedName("a")
   HashSet field574;
   @ObfuscatedName("y")
   List field575;
   @ObfuscatedName("x")
   HashSet field576;
   @ObfuscatedName("gj")
   static SpritePixels field577;

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(LBuffer;ZS)V",
      garbageValue = "4571"
   )
   void method607(Buffer var1, boolean var2) {
      this.field575 = new LinkedList();
      int var3 = var1.readUnsignedShort();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.method3338();
         Coordinates var6 = new Coordinates(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.field575.add(new class25(var5, var6));
         }
      }

   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(LBuffer;LBuffer;LBuffer;IZI)V",
      garbageValue = "50856291"
   )
   void method609(Buffer var1, Buffer var2, Buffer var3, int var4, boolean var5) {
      this.loadMapData(var1, var4);
      int var6 = var3.readUnsignedShort();
      this.field576 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class22 var8 = new class22();

         try {
            var8.method177(var2, var3);
         } catch (IllegalStateException var13) {
            continue;
         }

         this.field576.add(var8);
      }

      var7 = var3.readUnsignedShort();
      this.field574 = new HashSet(var7);

      for(int var11 = 0; var11 < var7; ++var11) {
         class45 var9 = new class45();

         try {
            var9.method622(var2, var3);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field574.add(var9);
      }

      this.method607(var2, var5);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1571831038"
   )
   public static void method613(int var0) {
      if(class203.field2515 != 0) {
         FileOnDisk.field1774 = var0;
      } else {
         class203.field2517.method3773(var0);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "297649749"
   )
   public static int method614(int var0) {
      return var0 >> 17 & 7;
   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIZS)V",
      garbageValue = "18557"
   )
   static final void method615(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            if(var6) {
               Client.field1062 = Client.menuOptionCount;
            }

            ++Client.menuOptionCount;
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "314136059"
   )
   public static boolean method616() {
      return class203.field2515 != 0?true:class203.field2517.method3757();
   }

   @ObfuscatedName("p")
   public static String method617(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5 = new StringBuilder(var2);

            while(0L != var0) {
               long var6 = var0;
               var0 /= 37L;
               var5.append(class268.field3683[(int)(var6 - 37L * var0)]);
            }

            return var5.reverse().toString();
         }
      } else {
         return null;
      }
   }
}
