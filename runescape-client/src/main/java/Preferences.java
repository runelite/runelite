import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
@Implements("Preferences")
public class Preferences {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1456529283
   )
   static int field1299;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -880262315
   )
   @Export("screenType")
   int screenType;
   @ObfuscatedName("m")
   @Export("preferences")
   LinkedHashMap preferences;
   @ObfuscatedName("i")
   @Export("hideRoofs")
   boolean hideRoofs;
   @ObfuscatedName("u")
   @Export("muted")
   boolean muted;

   static {
      field1299 = 4;
   }

   Preferences() {
      this.screenType = 1;
      this.preferences = new LinkedHashMap();
      this.method1540(true);
   }

   @ObfuscatedSignature(
      signature = "(Lfp;)V"
   )
   Preferences(Buffer var1) {
      this.screenType = 1;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field1299) {
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
            this.method1540(true);
         }
      } else {
         this.method1540(true);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1090042905"
   )
   void method1540(boolean var1) {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)Lfp;",
      garbageValue = "-17634"
   )
   @Export("serialize")
   Buffer serialize() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field1299);
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IZIZI)V",
      garbageValue = "-264360141"
   )
   static void method1551(int var0, boolean var1, int var2, boolean var3) {
      if(class64.worldList != null) {
         PendingSpawn.method1464(0, class64.worldList.length - 1, var0, var1, var2, var3);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SI)V",
      garbageValue = "-470110690"
   )
   public static void method1539(String[] var0, short[] var1) {
      class66.method1042(var0, var1, 0, var0.length - 1);
   }
}
