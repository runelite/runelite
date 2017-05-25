import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
public class class69 extends Node {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -658509625
   )
   int field814;
   @ObfuscatedName("a")
   String field815;
   @ObfuscatedName("u")
   Widget field816;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1716005791
   )
   int field817;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 661989385
   )
   int field818;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 347700555
   )
   int field819;
   @ObfuscatedName("t")
   Widget field820;
   @ObfuscatedName("h")
   boolean field821;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 872924365
   )
   int field822;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 711686955
   )
   int field824;
   @ObfuscatedName("r")
   class219 field825;
   @ObfuscatedName("i")
   Object[] field826;

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1709631282"
   )
   static final void method1107() {
      Client.secretPacketBuffer2.method3469();
      int var0 = Client.secretPacketBuffer2.method3470(8);
      int var1;
      if(var0 < Client.field928) {
         for(var1 = var0; var1 < Client.field928; ++var1) {
            Client.field1087[++Client.field1158 - 1] = Client.field1013[var1];
         }
      }

      if(var0 > Client.field928) {
         throw new RuntimeException("");
      } else {
         Client.field928 = 0;

         for(var1 = 0; var1 < var0; ++var1) {
            int var2 = Client.field1013[var1];
            NPC var3 = Client.cachedNPCs[var2];
            int var4 = Client.secretPacketBuffer2.method3470(1);
            if(var4 == 0) {
               Client.field1013[++Client.field928 - 1] = var2;
               var3.field1245 = Client.gameCycle;
            } else {
               int var5 = Client.secretPacketBuffer2.method3470(2);
               if(var5 == 0) {
                  Client.field1013[++Client.field928 - 1] = var2;
                  var3.field1245 = Client.gameCycle;
                  Client.field931[++Client.field930 - 1] = var2;
               } else {
                  int var6;
                  int var7;
                  if(var5 == 1) {
                     Client.field1013[++Client.field928 - 1] = var2;
                     var3.field1245 = Client.gameCycle;
                     var6 = Client.secretPacketBuffer2.method3470(3);
                     var3.method1711(var6, (byte)1);
                     var7 = Client.secretPacketBuffer2.method3470(1);
                     if(var7 == 1) {
                        Client.field931[++Client.field930 - 1] = var2;
                     }
                  } else if(var5 == 2) {
                     Client.field1013[++Client.field928 - 1] = var2;
                     var3.field1245 = Client.gameCycle;
                     var6 = Client.secretPacketBuffer2.method3470(3);
                     var3.method1711(var6, (byte)2);
                     var7 = Client.secretPacketBuffer2.method3470(3);
                     var3.method1711(var7, (byte)2);
                     int var8 = Client.secretPacketBuffer2.method3470(1);
                     if(var8 == 1) {
                        Client.field931[++Client.field930 - 1] = var2;
                     }
                  } else if(var5 == 3) {
                     Client.field1087[++Client.field1158 - 1] = var2;
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass219;I)V",
      garbageValue = "1656762224"
   )
   public void method1109(class219 var1) {
      this.field825 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;I)V",
      garbageValue = "1884412792"
   )
   public void method1110(Object[] var1) {
      this.field826 = var1;
   }

   public class69() {
      this.field825 = class219.field2784;
   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(Lclass76;I)V",
      garbageValue = "1676523921"
   )
   static final void method1115(class76 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field1181 == 0) {
         var1 = class46.region.method2733(var0.field1174, var0.field1176, var0.field1177);
      }

      if(var0.field1181 == 1) {
         var1 = class46.region.method2734(var0.field1174, var0.field1176, var0.field1177);
      }

      if(var0.field1181 == 2) {
         var1 = class46.region.method2821(var0.field1174, var0.field1176, var0.field1177);
      }

      if(var0.field1181 == 3) {
         var1 = class46.region.method2736(var0.field1174, var0.field1176, var0.field1177);
      }

      if(var1 != 0) {
         int var5 = class46.region.method2896(var0.field1174, var0.field1176, var0.field1177, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field1178 = var2;
      var0.field1180 = var3;
      var0.field1179 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1028840217"
   )
   static void method1117() {
      class286.field3785 = null;
      class286.field3783 = null;
      class252.field3387 = null;
      class267.field3667 = null;
      class87.field1355 = null;
      MessageNode.field843 = null;
   }
}
