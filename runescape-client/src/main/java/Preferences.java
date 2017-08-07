import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("Preferences")
public class Preferences {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1495451393
   )
   static int field1294;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -165147115
   )
   @Export("screenType")
   int screenType;
   @ObfuscatedName("k")
   @Export("preferences")
   LinkedHashMap preferences;
   @ObfuscatedName("g")
   @Export("hideRoofs")
   boolean hideRoofs;
   @ObfuscatedName("y")
   @Export("muted")
   boolean muted;

   static {
      field1294 = 4;
   }

   Preferences() {
      this.screenType = 1;
      this.preferences = new LinkedHashMap();
      this.method1598(true);
   }

   @ObfuscatedSignature(
      signature = "(Lfh;)V"
   )
   Preferences(Buffer var1) {
      this.screenType = 1;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field1294) {
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
         } else {
            this.method1598(true);
         }
      } else {
         this.method1598(true);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "2003960684"
   )
   void method1598(boolean var1) {
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Lfh;",
      garbageValue = "119846439"
   )
   @Export("serialize")
   Buffer serialize() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field1294);
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

      return var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-790429194"
   )
   public static boolean method1607(int var0) {
      return var0 >= class222.field2801.field2804 && var0 <= class222.field2792.field2804 || var0 == class222.field2785.field2804;
   }
}
