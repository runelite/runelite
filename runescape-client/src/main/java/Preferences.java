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
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 921646939
   )
   static int field1236;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   static IndexedSprite field1235;
   @ObfuscatedName("a")
   static int[] field1227;
   @ObfuscatedName("i")
   @Export("hideRoofs")
   boolean hideRoofs;
   @ObfuscatedName("j")
   @Export("muted")
   boolean muted;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1237697821
   )
   @Export("screenType")
   int screenType;
   @ObfuscatedName("x")
   String field1231;
   @ObfuscatedName("e")
   boolean field1232;
   @ObfuscatedName("l")
   @Export("preferences")
   LinkedHashMap preferences;

   static {
      field1236 = 6;
   }

   Preferences() {
      this.screenType = 1;
      this.field1231 = null;
      this.field1232 = false;
      this.preferences = new LinkedHashMap();
      this.method1672(true);
   }

   @ObfuscatedSignature(
      signature = "(Lfv;)V"
   )
   Preferences(Buffer var1) {
      this.screenType = 1;
      this.field1231 = null;
      this.field1232 = false;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field1236) {
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
               this.field1231 = var1.getNullString();
            }

            if(var2 > 5) {
               this.field1232 = var1.method3320();
            }
         } else {
            this.method1672(true);
         }
      } else {
         this.method1672(true);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "0"
   )
   void method1672(boolean var1) {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Lfv;",
      garbageValue = "1640976032"
   )
   @Export("serialize")
   Buffer serialize() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field1236);
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

      var1.putString(this.field1231 != null?this.field1231:"");
      var1.method3275(this.field1232);
      return var1;
   }

   @ObfuscatedName("m")
   public static String method1686(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class275.field3727[(int)(var6 - var0 * 37L)];
               if(var8 == '_') {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-52"
   )
   static int method1685(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "-1252649784"
   )
   static final void method1687(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      PendingSpawn var9 = null;

      for(PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.getFront(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0 == var10.level && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new PendingSpawn();
         var9.level = var0;
         var9.type = var3;
         var9.x = var1;
         var9.y = var2;
         Coordinates.method4109(var9);
         Client.pendingSpawns.addFront(var9);
      }

      var9.id = var4;
      var9.field1140 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      signature = "(Lhk;B)I",
      garbageValue = "119"
   )
   @Export("getWidgetConfig")
   static int getWidgetConfig(Widget var0) {
      IntegerNode var1 = (IntegerNode)Client.widgetFlags.get((long)var0.index + ((long)var0.id << 32));
      return var1 != null?var1.value:var0.config;
   }
}
