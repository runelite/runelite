import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("Preferences")
public class Preferences {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -801246797
   )
   static int field1229;
   @ObfuscatedName("r")
   @Export("hideRoofs")
   boolean hideRoofs;
   @ObfuscatedName("g")
   @Export("muted")
   boolean muted;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -190442965
   )
   @Export("screenType")
   int screenType;
   @ObfuscatedName("f")
   String field1232;
   @ObfuscatedName("u")
   boolean field1235;
   @ObfuscatedName("t")
   @Export("preferences")
   LinkedHashMap preferences;

   static {
      field1229 = 6;
   }

   Preferences() {
      this.screenType = 1;
      this.field1232 = null;
      this.field1235 = false;
      this.preferences = new LinkedHashMap();
      this.method1566(true);
   }

   @ObfuscatedSignature(
      signature = "(Lfs;)V"
   )
   Preferences(Buffer var1) {
      this.screenType = 1;
      this.field1232 = null;
      this.field1235 = false;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field1229) {
            if(var1.readUnsignedByte() == 1) {
               this.hideRoofs = true;
            }

            if(var2 > 1) {
               this.muted = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.screenType = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.readInt();
                  int var6 = var1.readInt();
                  this.preferences.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }

            if(var2 > 4) {
               this.field1232 = var1.getNullString();
            }

            if(var2 > 5) {
               this.field1235 = var1.method3193();
            }
         } else {
            this.method1566(true);
         }
      } else {
         this.method1566(true);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1291410218"
   )
   void method1566(boolean var1) {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Lfs;",
      garbageValue = "1224367894"
   )
   @Export("serialize")
   Buffer serialize() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field1229);
      var1.putByte(this.hideRoofs?1:0);
      var1.putByte(this.muted?1:0);
      var1.putByte(this.screenType);
      var1.putByte(this.preferences.size());
      Iterator var2 = this.preferences.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.putInt(((Integer)var3.getKey()).intValue());
         var1.putInt(((Integer)var3.getValue()).intValue());
      }

      var1.putString(this.field1232 != null?this.field1232:"");
      var1.method3176(this.field1235);
      return var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIIB)Ljava/lang/String;",
      garbageValue = "-36"
   )
   public static String method1574(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;
      int var5 = var1;

      int var8;
      for(int var6 = var2 + var1; var5 < var6; var3[var4++] = (char)var8) {
         int var7 = var0[var5++] & 255;
         if(var7 < 128) {
            if(var7 == 0) {
               var8 = 65533;
            } else {
               var8 = var7;
            }
         } else if(var7 < 192) {
            var8 = 65533;
         } else if(var7 < 224) {
            if(var5 < var6 && (var0[var5] & 192) == 128) {
               var8 = (var7 & 31) << 6 | var0[var5++] & 63;
               if(var8 < 128) {
                  var8 = 65533;
               }
            } else {
               var8 = 65533;
            }
         } else if(var7 < 240) {
            if(var5 + 1 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128) {
               var8 = (var7 & 15) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 < 2048) {
                  var8 = 65533;
               }
            } else {
               var8 = 65533;
            }
         } else if(var7 < 248) {
            if(var5 + 2 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128 && (var0[var5 + 2] & 192) == 128) {
               var8 = (var7 & 7) << 18 | (var0[var5++] & 63) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 >= 65536 && var8 <= 1114111) {
                  var8 = 65533;
               } else {
                  var8 = 65533;
               }
            } else {
               var8 = 65533;
            }
         } else {
            var8 = 65533;
         }
      }

      return new String(var3, 0, var4);
   }
}
