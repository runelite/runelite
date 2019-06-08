import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
@Implements("ClientPreferences")
public class ClientPreferences {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1548448409
   )
   @Export("__bf_m")
   static int __bf_m;
   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "[Lln;"
   )
   @Export("headIconPrayerSprites")
   static Sprite[] headIconPrayerSprites;
   @ObfuscatedName("q")
   @Export("roofsHidden")
   boolean roofsHidden;
   @ObfuscatedName("w")
   @Export("titleMusicDisabled")
   boolean titleMusicDisabled;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -359530975
   )
   @Export("windowMode")
   int windowMode;
   @ObfuscatedName("u")
   @Export("rememberedUsername")
   String rememberedUsername;
   @ObfuscatedName("g")
   @Export("hideUsername")
   boolean hideUsername;
   @ObfuscatedName("l")
   @Export("parameters")
   LinkedHashMap parameters;

   static {
      __bf_m = 6;
   }

   ClientPreferences() {
      this.windowMode = 1;
      this.rememberedUsername = null;
      this.hideUsername = false;
      this.parameters = new LinkedHashMap();
      this.__m_150(true);
   }

   @ObfuscatedSignature(
      signature = "(Lgr;)V"
   )
   ClientPreferences(Buffer var1) {
      this.windowMode = 1;
      this.rememberedUsername = null;
      this.hideUsername = false;
      this.parameters = new LinkedHashMap();
      if(var1 != null && var1.array != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= __bf_m) {
            if(var1.readUnsignedByte() == 1) {
               this.roofsHidden = true;
            }

            if(var2 > 1) {
               this.titleMusicDisabled = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.windowMode = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.readInt();
                  int var6 = var1.readInt();
                  this.parameters.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }

            if(var2 > 4) {
               this.rememberedUsername = var1.readStringCp1252NullTerminatedOrNull();
            }

            if(var2 > 5) {
               this.hideUsername = var1.readBoolean();
            }
         } else {
            this.__m_150(true);
         }
      } else {
         this.__m_150(true);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1213718182"
   )
   @Export("__m_150")
   void __m_150(boolean var1) {
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Lgr;",
      garbageValue = "-469810794"
   )
   @Export("toBuffer")
   Buffer toBuffer() {
      Buffer var1 = new Buffer(100);
      var1.writeByte(__bf_m);
      var1.writeByte(this.roofsHidden?1:0);
      var1.writeByte(this.titleMusicDisabled?1:0);
      var1.writeByte(this.windowMode);
      var1.writeByte(this.parameters.size());
      Iterator var2 = this.parameters.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.writeInt(((Integer)var3.getKey()).intValue());
         var1.writeInt(((Integer)var3.getValue()).intValue());
      }

      var1.writeStringCp1252NullTerminated(this.rememberedUsername != null?this.rememberedUsername:"");
      var1.writeBoolean(this.hideUsername);
      return var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-1"
   )
   public static int method1808(int var0) {
      return HitSplatDefinition.method4972(ViewportMouse.ViewportMouse_entityTags[var0]);
   }

   @ObfuscatedName("jl")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   static final void method1809(int var0) {
      if(GroundItemPile.loadWidgetGroup(var0)) {
         NetFileRequest.method4555(Widget.widgets[var0], -1);
      }
   }
}
