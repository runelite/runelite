import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   static IndexDataBase field1565;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "[Lbt;"
   )
   @Export("lines")
   MessageNode[] lines;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1103196823
   )
   @Export("length")
   int length;

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)Lbt;",
      garbageValue = "-52"
   )
   @Export("addMessage")
   MessageNode addMessage(int var1, String var2, String var3, String var4) {
      MessageNode var5 = this.lines[99];

      for(int var6 = this.length; var6 > 0; --var6) {
         if(var6 != 100) {
            this.lines[var6] = this.lines[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new MessageNode(var1, var2, var4, var3);
      } else {
         var5.unlink();
         var5.unlinkDual();
         var5.setMessage(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)Lbt;",
      garbageValue = "98"
   )
   MessageNode method1868(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1159945325"
   )
   int method1869() {
      return this.length;
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-720413109"
   )
   static final void method1867(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field1065; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1110[var4] = true;
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIIS)Z",
      garbageValue = "-21392"
   )
   static final boolean method1876(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      Buffer var4 = new Buffer(var0);
      int var5 = -1;

      label69:
      while(true) {
         int var6 = var4.getUSmart();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.getUSmart();
               if(var9 == 0) {
                  continue label69;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.readUnsignedByte() >> 2;
               int var13 = var11 + var1;
               int var14 = var10 + var2;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  ObjectComposition var15 = GameObject.getObjectDefinition(var5);
                  if(var12 != 22 || !Client.lowMemory || var15.field3454 != 0 || var15.interactType == 1 || var15.field3451) {
                     if(!var15.method4521()) {
                        ++Client.field1033;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.getUSmart();
            if(var9 == 0) {
               break;
            }

            var4.readUnsignedByte();
         }
      }
   }
}
