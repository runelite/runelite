import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class15 extends class21 {
   @ObfuscatedName("si")
   @ObfuscatedGetter(
      longValue = 3423502126894795079L
   )
   @Export("__z_si")
   static long __z_si;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   @Export("worldMapEvent")
   static WorldMapEvent worldMapEvent;
   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("serverBuild")
   static ServerBuild serverBuild;
   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "[Lln;"
   )
   @Export("headIconPkSprites")
   static Sprite[] headIconPkSprites;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "962518033"
   )
   void method173(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if(var2 != class31.field259.field255) {
         throw new IllegalStateException("");
      } else {
         super.field148 = var1.readUnsignedByte();
         super.field156 = var1.readUnsignedByte();
         super.field149 = var1.__ag_302();
         super.field146 = var1.__ag_302();
         super.field159 = var1.__ag_302();
         super.field147 = var1.__ag_302();
         super.field150 = var1.__ap_310();
         super.field152 = var1.__ap_310();
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "1937224298"
   )
   void vmethod715(Buffer var1) {
      super.field156 = Math.min(super.field156, 4);
      super.field151 = new short[1][64][64];
      super.field145 = new short[super.field156][64][64];
      super.field154 = new byte[super.field156][64][64];
      super.field155 = new byte[super.field156][64][64];
      super.field144 = new class25[super.field156][64][64][];
      int var2 = var1.readUnsignedByte();
      if(var2 != class30.field246.field248) {
         throw new IllegalStateException("");
      } else {
         int var3 = var1.readUnsignedByte();
         int var4 = var1.readUnsignedByte();
         if(var3 == super.field159 && var4 == super.field147) {
            for(int var5 = 0; var5 < 64; ++var5) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  this.method259(var5, var6, var1);
               }
            }

         } else {
            throw new IllegalStateException("");
         }
      }
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class15)) {
         return false;
      } else {
         class15 var2 = (class15)var1;
         return super.field159 == var2.field159 && super.field147 == var2.field147;
      }
   }

   public int hashCode() {
      return super.field159 | super.field147 << 8;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "3"
   )
   static final int method183(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "2139921057"
   )
   static int method182(int var0, Script var1, boolean var2) {
      Widget var3 = Huffman.getWidget(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
      if(var0 == 2800) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = class211.method4107(class1.getWidgetClickMask(var3));
         return 1;
      } else if(var0 != 2801) {
         if(var0 == 2802) {
            if(var3.dataText == null) {
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
            } else {
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.dataText;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var4 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
         --var4;
         if(var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.actions[var4];
         } else {
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
         }

         return 1;
      }
   }

   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1757982583"
   )
   static final void method184(boolean var0) {
      if(var0) {
         Client.field658 = Login.__cu_ba?class159.field1980:class159.field1983;
      } else {
         Client.field658 = ReflectionCheck.clientPreferences.parameters.containsKey(Integer.valueOf(class279.method5357(Login.Login_username)))?class159.field1982:class159.field1985;
      }

   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "(Lho;I)V",
      garbageValue = "1585987978"
   )
   static final void method186(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 324) {
         if(Client.__client_sd == -1) {
            Client.__client_sd = var0.spriteId2;
            Client.__client_sl = var0.spriteId;
         }

         if(Client.__client_ru.isFemale) {
            var0.spriteId2 = Client.__client_sd;
         } else {
            var0.spriteId2 = Client.__client_sl;
         }

      } else if(var1 == 325) {
         if(Client.__client_sd == -1) {
            Client.__client_sd = var0.spriteId2;
            Client.__client_sl = var0.spriteId;
         }

         if(Client.__client_ru.isFemale) {
            var0.spriteId2 = Client.__client_sl;
         } else {
            var0.spriteId2 = Client.__client_sd;
         }

      } else if(var1 == 327) {
         var0.modelAngleX = 150;
         var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if(var1 == 328) {
         var0.modelAngleX = 150;
         var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
      }
   }
}
