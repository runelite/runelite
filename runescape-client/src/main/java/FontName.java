import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kr")
@Implements("FontName")
public class FontName {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   @Export("FontName_plain11")
   public static final FontName FontName_plain11;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   @Export("FontName_plain12")
   public static final FontName FontName_plain12;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   @Export("FontName_bold12")
   public static final FontName FontName_bold12;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   public static final FontName field3868;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   public static final FontName field3870;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   public static final FontName field3867;
   @ObfuscatedName("k")
   final String field3873;
   @ObfuscatedName("s")
   String field3874;

   static {
      FontName_plain11 = new FontName("PLAIN11", "p11_full");
      FontName_plain12 = new FontName("PLAIN12", "p12_full");
      FontName_bold12 = new FontName("BOLD12", "b12_full");
      field3868 = new FontName("VERDANA11", "verdana_11pt_regular");
      field3870 = new FontName("VERDANA13", "verdana_13pt_regular");
      field3867 = new FontName("VERDANA15", "verdana_15pt_regular");
   }

   FontName(String var1, String var2) {
      this.field3873 = var1;
      this.field3874 = var2;
   }

   @ObfuscatedName("d")
   public static String method5594(long var0) {
      class204.field2621.setTime(new Date(var0));
      int var2 = class204.field2621.get(7);
      int var3 = class204.field2621.get(5);
      int var4 = class204.field2621.get(2);
      int var5 = class204.field2621.get(1);
      int var6 = class204.field2621.get(11);
      int var7 = class204.field2621.get(12);
      int var8 = class204.field2621.get(13);
      return class204.field2620[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class204.field2622[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1915591477"
   )
   static void method5595() {
      if(class90.Login_isUsernameRemembered && class90.username != null && class90.username.length() > 0) {
         class90.field1364 = 1;
      } else {
         class90.field1364 = 0;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1379482435"
   )
   @Export("decodeSprite")
   static void decodeSprite(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class18.field325 = var1.readUnsignedShort();
      class332.field3990 = new int[class18.field325];
      class332.offsetsY = new int[class18.field325];
      Varbit.field3539 = new int[class18.field325];
      BoundingBox2D.field242 = new int[class18.field325];
      class332.spritePixels = new byte[class18.field325][];
      var1.offset = var0.length - 7 - class18.field325 * 8;
      class332.field3995 = var1.readUnsignedShort();
      class332.field3991 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class18.field325; ++var3) {
         class332.field3990[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class18.field325; ++var3) {
         class332.offsetsY[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class18.field325; ++var3) {
         Varbit.field3539[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class18.field325; ++var3) {
         BoundingBox2D.field242[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class18.field325 * 8 - (var2 - 1) * 3;
      class332.field3994 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class332.field3994[var3] = var1.read24BitInt();
         if(class332.field3994[var3] == 0) {
            class332.field3994[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class18.field325; ++var3) {
         int var4 = Varbit.field3539[var3];
         int var5 = BoundingBox2D.field242[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         class332.spritePixels[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var4 * var10] = var1.readByte();
               }
            }
         }
      }

   }
}
