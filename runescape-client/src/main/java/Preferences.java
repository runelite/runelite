import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("Preferences")
public class Preferences {
   @ObfuscatedName("rq")
   @ObfuscatedSignature(
      signature = "Llp;"
   )
   @Export("renderOverview")
   static RenderOverview renderOverview;
   @ObfuscatedName("ra")
   static short[] field1248;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -865807965
   )
   static int field1249;
   @ObfuscatedName("t")
   @Export("hideRoofs")
   boolean hideRoofs;
   @ObfuscatedName("d")
   @Export("muted")
   boolean muted;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2068550845
   )
   @Export("screenType")
   int screenType;
   @ObfuscatedName("m")
   @Export("rememberedUsername")
   String rememberedUsername;
   @ObfuscatedName("z")
   @Export("hideUsername")
   boolean hideUsername;
   @ObfuscatedName("i")
   @Export("preferences")
   LinkedHashMap preferences;

   static {
      field1249 = 6;
   }

   Preferences() {
      this.screenType = 1;
      this.rememberedUsername = null;
      this.hideUsername = false;
      this.preferences = new LinkedHashMap();
      this.method1727(true);
   }

   @ObfuscatedSignature(
      signature = "(Lgc;)V"
   )
   Preferences(Buffer var1) {
      this.screenType = 1;
      this.rememberedUsername = null;
      this.hideUsername = false;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field1249) {
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
               this.hideUsername = var1.method3524();
            }
         } else {
            this.method1727(true);
         }
      } else {
         this.method1727(true);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "2000642703"
   )
   void method1727(boolean var1) {
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Lgc;",
      garbageValue = "468796044"
   )
   @Export("serialize")
   Buffer serialize() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field1249);
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
}
