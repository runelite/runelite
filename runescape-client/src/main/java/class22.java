import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class22 extends class28 {
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 248847613
   )
   static int field335;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = 847231757
   )
   @Export("selectedItemIndex")
   static int selectedItemIndex;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgv;Lgv;B)V",
      garbageValue = "2"
   )
   void method154(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field484.field485) {
         throw new IllegalStateException("");
      } else {
         super.field389 = var2.readUnsignedByte();
         super.field393 = var2.readUnsignedByte();
         super.field390 = var2.readUnsignedShort();
         super.field388 = var2.readUnsignedShort();
         super.field392 = var2.readUnsignedShort();
         super.field391 = var2.readUnsignedShort();
         super.field393 = Math.min(super.field393, 4);
         super.field394 = new short[1][64][64];
         super.field395 = new short[super.field393][64][64];
         super.field396 = new byte[super.field393][64][64];
         super.field397 = new byte[super.field393][64][64];
         super.field398 = new class31[super.field393][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field472.field470) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(var4 == super.field392 && var5 == super.field391) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method211(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   public int hashCode() {
      return super.field392 | super.field391 << 8;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class22)) {
         return false;
      } else {
         class22 var2 = (class22)var1;
         return var2.field392 == super.field392 && var2.field391 == super.field391;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1408403627"
   )
   static int method163(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      return class29.currentRequest != null && var2 == class29.currentRequest.hash?class231.NetCache_responseArchiveBuffer.offset * 99 / (class231.NetCache_responseArchiveBuffer.payload.length - class29.currentRequest.padding) + 1:0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgv;J)V"
   )
   static void method166(Buffer var0, long var1) {
      var1 /= 10L;
      if(var1 < 0L) {
         var1 = 0L;
      } else if(var1 > 65535L) {
         var1 = 65535L;
      }

      var0.putShort((int)var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-28351"
   )
   public static void method165() {
      PlayerComposition.field2734.reset();
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1817988089"
   )
   static String method162(int var0) {
      return var0 < 0?"":(Client.menuTargets[var0].length() > 0?Client.menuOptions[var0] + " " + Client.menuTargets[var0]:Client.menuOptions[var0]);
   }

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "(Lhq;I)V",
      garbageValue = "16776960"
   )
   static final void method164(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 324) {
         if(Client.field1060 == -1) {
            Client.field1060 = var0.spriteId;
            Client.field1128 = var0.field2798;
         }

         if(Client.field1126.isFemale) {
            var0.spriteId = Client.field1060;
         } else {
            var0.spriteId = Client.field1128;
         }

      } else if(var1 == 325) {
         if(Client.field1060 == -1) {
            Client.field1060 = var0.spriteId;
            Client.field1128 = var0.field2798;
         }

         if(Client.field1126.isFemale) {
            var0.spriteId = Client.field1128;
         } else {
            var0.spriteId = Client.field1060;
         }

      } else if(var1 == 327) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if(var1 == 328) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
      }
   }
}
