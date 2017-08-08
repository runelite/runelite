import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
final class class17 implements Comparator {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ls;Ls;I)I",
      garbageValue = "2078010663"
   )
   int method117(class14 var1, class14 var2) {
      return var1.field288.price < var2.field288.price?-1:(var2.field288.price == var1.field288.price?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method117((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1365525992"
   )
   public static void method127() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         ++KeyFocusListener.keyboardIdleTicks;
         KeyFocusListener.field630 = KeyFocusListener.field618;
         KeyFocusListener.field643 = 0;
         int var1;
         if(KeyFocusListener.field634 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               KeyFocusListener.field631[var1] = false;
            }

            KeyFocusListener.field634 = KeyFocusListener.field626;
         } else {
            while(KeyFocusListener.field626 != KeyFocusListener.field634) {
               var1 = KeyFocusListener.field642[KeyFocusListener.field626];
               KeyFocusListener.field626 = KeyFocusListener.field626 + 1 & 127;
               if(var1 < 0) {
                  KeyFocusListener.field631[~var1] = false;
               } else {
                  if(!KeyFocusListener.field631[var1] && KeyFocusListener.field643 < KeyFocusListener.field637.length - 1) {
                     KeyFocusListener.field637[++KeyFocusListener.field643 - 1] = var1;
                  }

                  KeyFocusListener.field631[var1] = true;
               }
            }
         }

         if(KeyFocusListener.field643 > 0) {
            KeyFocusListener.keyboardIdleTicks = 0;
         }

         KeyFocusListener.field618 = KeyFocusListener.field636;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BIII)Z",
      garbageValue = "-681512895"
   )
   static final boolean method126(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      Buffer var4 = new Buffer(var0);
      int var5 = -1;

      label68:
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
                  continue label68;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.readUnsignedByte() >> 2;
               int var13 = var11 + var1;
               int var14 = var10 + var2;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  ObjectComposition var15 = WorldMapType1.getObjectDefinition(var5);
                  if(var12 != 22 || !Client.lowMemory || var15.field3435 != 0 || var15.interactType == 1 || var15.field3464) {
                     if(!var15.method4578()) {
                        ++Client.field971;
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1975079330"
   )
   @Export("addChatMessage")
   @Hook("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class99.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class99.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.addMessage(var0, var1, var2, var3);
      class99.field1516.put(var5, (long)var5.id);
      class99.field1520.method3674(var5);
      Client.chatCycle = Client.cycleCntr;
   }
}
