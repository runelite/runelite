import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
public enum class228 implements RSEnum {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field3131(5, 0),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field3121(7, 1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field3122(3, 2),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field3124(6, 3),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field3120(2, 4),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field3125(4, 5),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field3128(0, 6),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field3126(1, 7);

   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -560088929
   )
   public final int field3127;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -16769939
   )
   final int field3129;

   class228(int var3, int var4) {
      this.field3127 = var3;
      this.field3129 = var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1443879177"
   )
   public int rsOrdinal() {
      return this.field3129;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lix;IIIBZI)V",
      garbageValue = "-283726567"
   )
   static void method3983(IndexData var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      FileRequest var8 = (FileRequest)class238.field3224.get(var6);
      if(var8 == null) {
         var8 = (FileRequest)class238.field3233.get(var6);
         if(var8 == null) {
            var8 = (FileRequest)class238.field3227.get(var6);
            if(var8 != null) {
               if(var5) {
                  var8.unlinkDual();
                  class238.field3224.put(var8, var6);
                  --class238.field3221;
                  ++class238.field3225;
               }

            } else {
               if(!var5) {
                  var8 = (FileRequest)class238.field3231.get(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new FileRequest();
               var8.index = var0;
               var8.crc = var3;
               var8.padding = var4;
               if(var5) {
                  class238.field3224.put(var8, var6);
                  ++class238.field3225;
               } else {
                  class238.field3232.push(var8);
                  class238.field3227.put(var8, var6);
                  ++class238.field3221;
               }

            }
         }
      }
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(Lho;I)Z",
      garbageValue = "524222548"
   )
   static final boolean method3987(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field967 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field1080.method3877(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field1080.method3897(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field1080.method3879(false);
         }

         if(var1 == 325) {
            Client.field1080.method3879(true);
         }

         if(var1 == 326) {
            Client.secretPacketBuffer1.putOpcode(87);
            Client.field1080.method3880(Client.secretPacketBuffer1);
            return true;
         } else {
            return false;
         }
      }
   }
}
