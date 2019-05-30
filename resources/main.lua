require('com.hand13.lua.module.hello')
function test()
    for i=1,10
    do
        hello.logger("nice to meet you")
    end
    return "done"
end