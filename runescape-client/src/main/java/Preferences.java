import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("Preferences")
public class Preferences {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1024797975
   )
   static int field1212;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -233733647
   )
   static int field1217;
   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("indexCache13")
   static IndexData indexCache13;
   @ObfuscatedName("e")
   @Export("hideRoofs")
   boolean hideRoofs;
   @ObfuscatedName("k")
   @Export("muted")
   boolean muted;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -881826075
   )
   @Export("screenType")
   int screenType;
   @ObfuscatedName("z")
   @Export("rememberedUsername")
   String rememberedUsername;
   @ObfuscatedName("t")
   @Export("hideUsername")
   boolean hideUsername;
   @ObfuscatedName("f")
   @Export("preferences")
   LinkedHashMap preferences;

   static {
      field1212 = 6;
   }

   Preferences() {
      this.screenType = 1;
      this.rememberedUsername = null;
      this.hideUsername = false;
      this.preferences = new LinkedHashMap();
      this.method1527(true);
   }

   @ObfuscatedSignature(
      signature = "(Lgh;)V"
   )
   Preferences(Buffer var1) {
      this.screenType = 1;
      this.rememberedUsername = null;
      this.hideUsername = false;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field1212) {
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
               this.rememberedUsername = var1.getNullString();
            }

            if(var2 > 5) {
               this.hideUsername = var1.method3268();
            }
         } else {
            this.method1527(true);
         }
      } else {
         this.method1527(true);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-78"
   )
   void method1527(boolean var1) {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Lgh;",
      garbageValue = "49"
   )
   @Export("serialize")
   Buffer serialize() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field1212);
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

      var1.putString(this.rememberedUsername != null?this.rememberedUsername:"");
      var1.writeBooleanAsByte(this.hideUsername);
      return var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1168308091"
   )
   @Export("currentTimeMs")
   public static synchronized long currentTimeMs() {
      long var0 = System.currentTimeMillis();
      if(var0 < class186.currentTimeMsLast) {
         class186.currentTimeMsOffset += class186.currentTimeMsLast - var0;
      }

      class186.currentTimeMsLast = var0;
      return var0 + class186.currentTimeMsOffset;
   }
}
