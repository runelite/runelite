import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("Preferences")
public class Preferences {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1268161711
   )
   static int field1232;
   @ObfuscatedName("y")
   @Export("hideRoofs")
   boolean hideRoofs;
   @ObfuscatedName("r")
   @Export("muted")
   boolean muted;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 792293341
   )
   @Export("screenType")
   int screenType;
   @ObfuscatedName("d")
   @Export("rememberedUsername")
   String rememberedUsername;
   @ObfuscatedName("s")
   @Export("hideUsername")
   boolean hideUsername;
   @ObfuscatedName("b")
   @Export("preferences")
   LinkedHashMap preferences;

   static {
      field1232 = 6;
   }

   Preferences() {
      this.screenType = 1;
      this.rememberedUsername = null;
      this.hideUsername = false;
      this.preferences = new LinkedHashMap();
      this.method1620(true);
   }

   @ObfuscatedSignature(
      signature = "(Lgv;)V"
   )
   Preferences(Buffer var1) {
      this.screenType = 1;
      this.rememberedUsername = null;
      this.hideUsername = false;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field1232) {
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
               this.hideUsername = var1.method3342();
            }
         } else {
            this.method1620(true);
         }
      } else {
         this.method1620(true);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "15"
   )
   void method1620(boolean var1) {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Lgv;",
      garbageValue = "1138688576"
   )
   @Export("serialize")
   Buffer serialize() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field1232);
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1610333101"
   )
   public static int method1619(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lbn;I)V",
      garbageValue = "2103162057"
   )
   public static void method1633(ScriptEvent var0) {
      BaseVarType.method7(var0, 200000);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "-125"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      ScriptVarType.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILcv;ZB)I",
      garbageValue = "30"
   )
   static int method1634(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = UrlRequester.getWidget(class82.intStack[--class82.intStackSize]);
      } else {
         var3 = var2?class82.field1267:CombatInfo1.field1216;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class82.intStack[--class82.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.setAction(var4, class82.scriptStringStack[--FileOnDisk.scriptStringStackSize]);
            return 1;
         } else {
            --FileOnDisk.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class82.intStackSize -= 2;
         var4 = class82.intStack[class82.intStackSize];
         int var5 = class82.intStack[class82.intStackSize + 1];
         var3.dragParent = ScriptVarType.getWidgetChild(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2776 = class82.intStack[--class82.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2838 = class82.intStack[--class82.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.field2821 = class82.intStack[--class82.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.selectedAction = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }
}
