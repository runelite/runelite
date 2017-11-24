import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
@Implements("Preferences")
public class Preferences {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 59302549
   )
   static int field1231;
   @ObfuscatedName("bl")
   @Export("sessionToken")
   static String sessionToken;
   @ObfuscatedName("k")
   @Export("hideRoofs")
   boolean hideRoofs;
   @ObfuscatedName("z")
   @Export("muted")
   boolean muted;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -733073949
   )
   @Export("screenType")
   int screenType;
   @ObfuscatedName("m")
   String field1234;
   @ObfuscatedName("b")
   boolean field1237;
   @ObfuscatedName("t")
   @Export("preferences")
   LinkedHashMap preferences;

   static {
      field1231 = 6;
   }

   Preferences() {
      this.screenType = 1;
      this.field1234 = null;
      this.field1237 = false;
      this.preferences = new LinkedHashMap();
      this.method1635(true);
   }

   @ObfuscatedSignature(
      signature = "(Lfr;)V"
   )
   Preferences(Buffer var1) {
      this.screenType = 1;
      this.field1234 = null;
      this.field1237 = false;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field1231) {
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
               this.field1234 = var1.getNullString();
            }

            if(var2 > 5) {
               this.field1237 = var1.method3303();
            }
         } else {
            this.method1635(true);
         }
      } else {
         this.method1635(true);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "873178240"
   )
   void method1635(boolean var1) {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Lfr;",
      garbageValue = "2"
   )
   @Export("serialize")
   Buffer serialize() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field1231);
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

      var1.putString(this.field1234 != null?this.field1234:"");
      var1.method3286(this.field1237);
      return var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(CIB)I",
      garbageValue = "124"
   )
   public static int method1638(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}
