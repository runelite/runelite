import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("Preferences")
public class Preferences {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -54687157
   )
   static int field1312;
   @ObfuscatedName("ap")
   @Export("authCode")
   static String authCode;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1682627821
   )
   @Export("screenType")
   int screenType;
   @ObfuscatedName("g")
   @Export("preferences")
   LinkedHashMap preferences;
   @ObfuscatedName("f")
   @Export("hideRoofs")
   boolean hideRoofs;
   @ObfuscatedName("p")
   @Export("muted")
   boolean muted;

   static {
      field1312 = 4;
   }

   Preferences() {
      this.screenType = 1;
      this.preferences = new LinkedHashMap();
      this.method1588(true);
   }

   @ObfuscatedSignature(
      signature = "(Lfb;)V"
   )
   Preferences(Buffer var1) {
      this.screenType = 1;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field1312) {
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
            this.method1588(true);
         }
      } else {
         this.method1588(true);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1299744805"
   )
   void method1588(boolean var1) {
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Lfb;",
      garbageValue = "1350104424"
   )
   @Export("serialize")
   Buffer serialize() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field1312);
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

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "(Lhi;I)Lhi;",
      garbageValue = "1643039783"
   )
   static Widget method1598(Widget var0) {
      int var1 = Varcs.method1827(class262.getWidgetConfig(var0));
      if(var1 == 0) {
         return null;
      } else {
         for(int var2 = 0; var2 < var1; ++var2) {
            var0 = class84.method1670(var0.parentId);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Lcj;",
      garbageValue = "1876984807"
   )
   static Script method1597(int var0) {
      Script var1 = (Script)Script.field1548.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = FrameMap.indexScripts.getConfigData(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = class27.method233(var2);
            Script.field1548.put(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "-2082275775"
   )
   public static int method1591(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0 - (var3 - 1):7 - var1 - (var4 - 1)));
   }
}
