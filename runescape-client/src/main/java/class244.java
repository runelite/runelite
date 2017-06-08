import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
public class class244 extends CacheableNode {
   @ObfuscatedName("p")
   static NodeCache field3320;
   @ObfuscatedName("i")
   public boolean field3322;
   @ObfuscatedName("n")
   static IndexDataBase field3324;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-42397503"
   )
   void method4344(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4345(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "977430740"
   )
   void method4345(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3322 = true;
      }

   }

   static {
      field3320 = new NodeCache(64);
   }

   class244() {
      this.field3322 = false;
   }

   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1501489233"
   )
   static final void method4354(String var0) {
      if(var0 != null) {
         String var1 = CollisionData.method3023(var0, class13.field281);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.friendCount; ++var2) {
               Friend var3 = Client.friends[var2];
               String var4 = var3.name;
               String var5 = CollisionData.method3023(var4, class13.field281);
               if(class98.method1813(var0, var1, var4, var5)) {
                  --Client.friendCount;

                  for(int var6 = var2; var6 < Client.friendCount; ++var6) {
                     Client.friends[var6] = Client.friends[var6 + 1];
                  }

                  Client.field1109 = Client.field1110;
                  Client.secretPacketBuffer1.putOpcode(211);
                  Client.secretPacketBuffer1.putByte(Script.method1836(var0));
                  Client.secretPacketBuffer1.method3150(var0);
                  break;
               }
            }

         }
      }
   }
}
