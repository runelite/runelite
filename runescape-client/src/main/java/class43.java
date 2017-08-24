import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class43 {
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = 1841223693
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lcl;"
   )
   public static class102 field586;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   @Export("logoSprite")
   static IndexedSprite logoSprite;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1414990525
   )
   int field583;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1753126435
   )
   int field578;
   @ObfuscatedName("a")
   int[][] field577;
   @ObfuscatedName("o")
   int[][] field581;
   @ObfuscatedName("r")
   int[][] field580;
   @ObfuscatedName("n")
   int[][] field579;

   class43(int var1, int var2) {
      this.field583 = var1;
      this.field578 = var2;
      this.field577 = new int[var1][var2];
      this.field580 = new int[var1][var2];
      this.field581 = new int[var1][var2];
      this.field579 = new int[var1][var2];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "-19036"
   )
   int method645(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field583 && var2 < this.field578) {
         if(this.field581[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field577[var1][var2] / this.field579[var1][var2];
            int var4 = this.field580[var1][var2] / this.field579[var1][var2];
            int var5 = this.field581[var1][var2] / this.field579[var1][var2];
            return class56.method864((double)var3 / 256.0D, (double)var4 / 256.0D, (double)var5 / 256.0D);
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILiz;I)V",
      garbageValue = "-1073700995"
   )
   void method654(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field583 && var2 - var3 <= this.field578) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field583, var3 + var1);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field578, var3 + var2);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field577[var9][var10] += var4.hue * 256 / var4.hueMultiplier;
                     this.field580[var9][var10] += var4.saturation;
                     this.field581[var9][var10] += var4.lightness;
                     ++this.field579[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgi;ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1906147684"
   )
   static String method653(IterableHashTable var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         ObjectNode var3 = (ObjectNode)var0.get((long)var1);
         return var3 == null?var2:(String)var3.value;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BZB)Ljava/lang/Object;",
      garbageValue = "124"
   )
   public static Object method646(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !AbstractByteBuffer.field2414) {
            try {
               DirectByteBuffer var2 = new DirectByteBuffer();
               var2.put(var0);
               return var2;
            } catch (Throwable var3) {
               AbstractByteBuffer.field2414 = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfn;II)V",
      garbageValue = "-222732011"
   )
   static final void method644(PacketBuffer var0, int var1) {
      int var2 = var0.offset;
      class95.field1514 = 0;
      GroundObject.method2495(var0);

      for(int var3 = 0; var3 < class95.field1514; ++var3) {
         int var4 = class95.field1510[var3];
         Player var5 = Client.cachedPlayers[var4];
         int var6 = var0.readUnsignedByte();
         if((var6 & 4) != 0) {
            var6 += var0.readUnsignedByte() << 8;
         }

         class226.method4108(var0, var4, var5, var6);
      }

      if(var0.offset - var2 != var1) {
         throw new RuntimeException(var0.offset - var2 + " " + var1);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZI)V",
      garbageValue = "-739068741"
   )
   static void method651(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class56.field692.startsWith("win") && !var3) {
            GraphicsObject.method1682(var0, 0);
            return;
         }

         if(class56.field692.startsWith("mac")) {
            class149.method2969(var0, 1, var2);
            return;
         }

         GraphicsObject.method1682(var0, 2);
      } else {
         GraphicsObject.method1682(var0, 3);
      }

   }
}
