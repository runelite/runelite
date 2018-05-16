import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
@Implements("Preferences")
public class Preferences {
   @ObfuscatedName("rn")
   @ObfuscatedSignature(
      signature = "Llz;"
   )
   @Export("renderOverview")
   static RenderOverview renderOverview;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 787405545
   )
   static int field986;
   @ObfuscatedName("av")
   protected static boolean field978;
   @ObfuscatedName("q")
   @Export("hideRoofs")
   boolean hideRoofs;
   @ObfuscatedName("b")
   @Export("muted")
   boolean muted;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 132306381
   )
   @Export("screenType")
   int screenType;
   @ObfuscatedName("n")
   @Export("rememberedUsername")
   String rememberedUsername;
   @ObfuscatedName("h")
   @Export("hideUsername")
   boolean hideUsername;
   @ObfuscatedName("x")
   @Export("preferences")
   LinkedHashMap preferences;

   static {
      field986 = 6;
   }

   Preferences() {
      this.screenType = 1;
      this.rememberedUsername = null;
      this.hideUsername = false;
      this.preferences = new LinkedHashMap();
      this.method1659(true);
   }

   @ObfuscatedSignature(
      signature = "(Lgy;)V"
   )
   Preferences(Buffer var1) {
      this.screenType = 1;
      this.rememberedUsername = null;
      this.hideUsername = false;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field986) {
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
               this.hideUsername = var1.method3656();
            }
         } else {
            this.method1659(true);
         }
      } else {
         this.method1659(true);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "93"
   )
   void method1659(boolean var1) {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)Lgy;",
      garbageValue = "-5"
   )
   @Export("serialize")
   Buffer serialize() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field986);
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILcs;ZI)I",
      garbageValue = "1360620841"
   )
   static int method1661(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 4200) {
         var3 = class69.intStack[--class45.intStackSize];
         class69.scriptStringStack[++class83.scriptStringStackSize - 1] = class120.getItemDefinition(var3).name;
         return 1;
      } else {
         int var4;
         ItemComposition var5;
         if(var0 == 4201) {
            class45.intStackSize -= 2;
            var3 = class69.intStack[class45.intStackSize];
            var4 = class69.intStack[class45.intStackSize + 1];
            var5 = class120.getItemDefinition(var3);
            if(var4 >= 1 && var4 <= 5 && var5.groundActions[var4 - 1] != null) {
               class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var5.groundActions[var4 - 1];
            } else {
               class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4202) {
            class45.intStackSize -= 2;
            var3 = class69.intStack[class45.intStackSize];
            var4 = class69.intStack[class45.intStackSize + 1];
            var5 = class120.getItemDefinition(var3);
            if(var4 >= 1 && var4 <= 5 && var5.inventoryActions[var4 - 1] != null) {
               class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var5.inventoryActions[var4 - 1];
            } else {
               class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4203) {
            var3 = class69.intStack[--class45.intStackSize];
            class69.intStack[++class45.intStackSize - 1] = class120.getItemDefinition(var3).price;
            return 1;
         } else if(var0 == 4204) {
            var3 = class69.intStack[--class45.intStackSize];
            class69.intStack[++class45.intStackSize - 1] = class120.getItemDefinition(var3).isStackable == 1?1:0;
            return 1;
         } else {
            ItemComposition var6;
            if(var0 == 4205) {
               var3 = class69.intStack[--class45.intStackSize];
               var6 = class120.getItemDefinition(var3);
               if(var6.notedTemplate == -1 && var6.note >= 0) {
                  class69.intStack[++class45.intStackSize - 1] = var6.note;
               } else {
                  class69.intStack[++class45.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4206) {
               var3 = class69.intStack[--class45.intStackSize];
               var6 = class120.getItemDefinition(var3);
               if(var6.notedTemplate >= 0 && var6.note >= 0) {
                  class69.intStack[++class45.intStackSize - 1] = var6.note;
               } else {
                  class69.intStack[++class45.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4207) {
               var3 = class69.intStack[--class45.intStackSize];
               class69.intStack[++class45.intStackSize - 1] = class120.getItemDefinition(var3).isMembers?1:0;
               return 1;
            } else if(var0 == 4208) {
               var3 = class69.intStack[--class45.intStackSize];
               var6 = class120.getItemDefinition(var3);
               if(var6.placeholderTemplateId == -1 && var6.placeholderId >= 0) {
                  class69.intStack[++class45.intStackSize - 1] = var6.placeholderId;
               } else {
                  class69.intStack[++class45.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4209) {
               var3 = class69.intStack[--class45.intStackSize];
               var6 = class120.getItemDefinition(var3);
               if(var6.placeholderTemplateId >= 0 && var6.placeholderId >= 0) {
                  class69.intStack[++class45.intStackSize - 1] = var6.placeholderId;
               } else {
                  class69.intStack[++class45.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4210) {
               String var7 = class69.scriptStringStack[--class83.scriptStringStackSize];
               var4 = class69.intStack[--class45.intStackSize];
               class16.method189(var7, var4 == 1);
               class69.intStack[++class45.intStackSize - 1] = MapIcon.field256;
               return 1;
            } else if(var0 != 4211) {
               if(var0 == 4212) {
                  ScriptEvent.field522 = 0;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               if(class137.field1889 != null && ScriptEvent.field522 < MapIcon.field256) {
                  class69.intStack[++class45.intStackSize - 1] = class137.field1889[++ScriptEvent.field522 - 1] & '\uffff';
               } else {
                  class69.intStack[++class45.intStackSize - 1] = -1;
               }

               return 1;
            }
         }
      }
   }
}
