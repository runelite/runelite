import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public class class170 {
   class170() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "1997218729"
   )
   static boolean method3237(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = FrameMap.method1697(var0, FaceNormal.field1561);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(FrameMap.method1697(var3.name, FaceNormal.field1561))) {
               return true;
            }

            if(var1.equalsIgnoreCase(FrameMap.method1697(var3.previousName, FaceNormal.field1561))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IZIZI)V",
      garbageValue = "-591399513"
   )
   static void method3238(int var0, boolean var1, int var2, boolean var3) {
      if(null != class5.worldList) {
         XClanMember.method250(0, class5.worldList.length - 1, var0, var1, var2, var3);
      }

   }
}
