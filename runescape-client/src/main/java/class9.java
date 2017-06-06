import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("n")
public abstract class class9 extends Node {
   @ObfuscatedName("be")
   static ModIcon[] field249;

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1811826637"
   )
   static final void method33() {
      for(int var0 = 0; var0 < Client.field1061; ++var0) {
         --Client.field1028[var0];
         if(Client.field1028[var0] >= -10) {
            SoundEffect var1 = Client.field1008[var0];
            if(var1 == null) {
               Object var10000 = null;
               var1 = SoundEffect.method1944(ChatLineBuffer.field1567, Client.field1171[var0], 0);
               if(var1 == null) {
                  continue;
               }

               Client.field1028[var0] += var1.method1945();
               Client.field1008[var0] = var1;
            }

            if(Client.field1028[var0] < 0) {
               int var2;
               if(Client.field956[var0] != 0) {
                  int var10 = (Client.field956[var0] & 255) * 128;
                  int var11 = Client.field956[var0] >> 16 & 255;
                  int var5 = var11 * 128 + 64 - World.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.field956[var0] >> 8 & 255;
                  int var7 = var6 * 128 + 64 - World.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var7 + var5 - 128;
                  if(var8 > var10) {
                     Client.field1028[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var10 - var8) * Client.field1169 / var10;
               } else {
                  var2 = Client.field1168;
               }

               if(var2 > 0) {
                  class107 var3 = var1.method1933().method1982(class137.field2055);
                  class117 var4 = class117.method2106(var3, 100, var2);
                  var4.method2224(Client.field1018[var0] - 1);
                  class158.field2288.method1884(var4);
               }

               Client.field1028[var0] = -100;
            }
         } else {
            --Client.field1061;

            for(int var9 = var0; var9 < Client.field1061; ++var9) {
               Client.field1171[var9] = Client.field1171[var9 + 1];
               Client.field1008[var9] = Client.field1008[var9 + 1];
               Client.field1018[var9] = Client.field1018[var9 + 1];
               Client.field1028[var9] = Client.field1028[var9 + 1];
               Client.field956[var9] = Client.field956[var9 + 1];
            }

            --var0;
         }
      }

      if(Client.field1123 && !class29.method230()) {
         if(Client.field1165 != 0 && Client.field1166 != -1) {
            class59.method985(class22.indexTrack1, Client.field1166, 0, Client.field1165, false);
         }

         Client.field1123 = false;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1403509867"
   )
   public abstract void vmethod44();

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-14129"
   )
   static void method39() {
      if(Client.field1085) {
         Widget var0 = FileOnDisk.method2351(ChatMessages.field1528, Client.field1086);
         if(var0 != null && var0.field2648 != null) {
            class69 var1 = new class69();
            var1.field852 = var0;
            var1.field849 = var0.field2648;
            Friend.method1075(var1);
         }

         Client.field1085 = false;
         class25.method169(var0);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;I)V",
      garbageValue = "-499661104"
   )
   public static void method40(IndexDataBase var0) {
      class240.field3276 = var0;
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "53"
   )
   static final void method41() {
      for(int var0 = 0; var0 < Client.field968; ++var0) {
         int var1 = Client.field950[var0];
         NPC var2 = Client.cachedNPCs[var1];
         if(var2 != null) {
            class61.method1050(var2, var2.composition.field3577);
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "-1362577657"
   )
   static Class method42(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }
}
